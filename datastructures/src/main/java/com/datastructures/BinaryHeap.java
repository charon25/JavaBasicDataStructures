package com.datastructures;

import java.util.ArrayList;

public class BinaryHeap {

    private IntList priorities;
    private ArrayList<String> keys;
    private StringHashTable<Integer> keyIndices;

    public BinaryHeap() {
        priorities = new IntList();
        keys = new ArrayList<>();
        keyIndices = new StringHashTable<>();
    }


    public int size() {
        return priorities.size();
    }


    private void upHeapify(int index) {
        // While child is smaller than its parent, swap them
        while (index > 0) {
            int currentPriority = priorities.get(index);
            int parentIndex = (index - 1) / 2;
            int parentPriority = priorities.get(parentIndex);

            if (parentPriority <= currentPriority) {
                break;
            }

            priorities.set(index, parentPriority);
            priorities.set(parentIndex, currentPriority);

            String currentKey = keys.get(index);
            String parentKey = keys.get(parentIndex);
            keys.set(index, parentKey);
            keys.set(parentIndex, currentKey);

            keyIndices.set(currentKey, parentIndex);
            keyIndices.set(parentKey, index);

            index = parentIndex;
        }
    }


    private void downHeapify(int index) {
        // While parent is greater than on of its children, swap them
        while (2 * index + 1 < priorities.size()) {
            int currentPriority = priorities.get(index);
            // Chose the left child by default, and switch to the right child if the latter is smaller
            int childIndex = 2 * index + 1;
            if (2 * index + 2 < priorities.size() && priorities.get(2 * index + 1) > priorities.get(2 * index + 2)) {
                childIndex ++;
            }
            int childPriority = priorities.get(childIndex);

            if (childPriority >= currentPriority) {
                break;
            }

            priorities.set(index, childPriority);
            priorities.set(childIndex, currentPriority);

            String currentKey = keys.get(index);
            String childKey = keys.get(childIndex);
            keys.set(index, childKey);
            keys.set(childIndex, currentKey);

            keyIndices.set(currentKey, childIndex);
            keyIndices.set(childKey, index);

            index = childIndex;
        }
    }


    public String getMin() {
        if (priorities.size() == 0) {
            return null;
        }

        return keys.get(0);
    }

    public void insert(String key, int priority) {
        int index = priorities.size();
        keyIndices.set(key, index);
        keys.add(key);
        priorities.append(priority);

        upHeapify(index);
    }

    public String extractMin() {
        if (priorities.size() == 0) {
            return null;
        } else if (priorities.size() == 1) {
            String minKey = keys.get(0);
            priorities = new IntList();
            keys = new ArrayList<>();
            keyIndices = new StringHashTable<>();

            return minKey;
        }

        int lastIndex = priorities.size() - 1;
        int lastPriority = priorities.get(-1);
        String minKey = keys.get(0);
        String lastKey = keys.get(keys.size() - 1);

        priorities.set(0, lastPriority);
        keyIndices.set(lastKey, 0);
        keys.set(0, lastKey);

        priorities.pop();
        keyIndices.delete(minKey);
        keys.remove(lastIndex);

        downHeapify(0);

        return minKey;
    }

    public void decreaseKey(String key, int newPriority) {
        int keyIndex = keyIndices.get(key, -1);
        if (keyIndex >= 0) {
            priorities.set(keyIndex, newPriority);
            upHeapify(keyIndex);
        }
    }

}
