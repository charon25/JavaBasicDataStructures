package com.datastructures;

import java.util.Arrays;
import java.util.Iterator;

public class IntList implements Iterable<Integer> {

    private final static int STARTING_SIZE = 32;

    private int[] elements;
    private int pointer;
    private int currentSize;

    public IntList() {
        elements = new int[STARTING_SIZE];
        currentSize = STARTING_SIZE;
        pointer = -1;
    }

    public IntList(int[] values) {
        int size = STARTING_SIZE;
        int valuesLength = values.length;
        while (size < valuesLength) {
            size *= 2;
        }

        elements = new int[size];
        for (int i = 0; i < valuesLength; i++) {
            elements[i] = values[i];
        }

        pointer = valuesLength - 1;
        currentSize = size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Arrays.stream(elements, 0, pointer + 1).iterator();
    }

    public void append(int value) {
        pointer++;

        if (pointer < currentSize) {
            elements[pointer] = value;

        } else {
            int[] newElements = new int[2 * currentSize];
            for (int i = 0; i < currentSize; i++) {
                newElements[i] = elements[i];
            }

            elements = newElements;
            elements[pointer] = value;

            currentSize *= 2;
        }
    }

    public int size() {
        return pointer + 1;
    }

    public int get(int index) {
        if (index > pointer || -index > pointer + 1) {
            throw new IndexOutOfBoundsException("list index out of range");
        }

        if (index >= 0) {
            return elements[index];
        }

        // Negative indices start from the end (-1 is the last element, so returns elements[pointer])
        return elements[pointer + index + 1];
    }

    public void set(int index, int value) {
        if (index > pointer || -index > pointer + 1) {
            throw new IndexOutOfBoundsException("list index out of range");
        }

        if (index < 0) {
            index = pointer + index + 1;
        }

        elements[index] = value;
    }

    public int pop(int index) {
        int value = get(index);

        if (index < 0) {
            index = pointer + index + 1;
        }

        for (int i = index; i < pointer; i++) {
            set(i, get(i + 1));
        }

        pointer--;
        
        return value;
    }

    public int pop() {
        return pop(-1);
    }

    public void remove(int value) {
        for (int i = 0; i < pointer; i++) {
            if (get(i) == value) {
                pop(i);
                return;
            }
        }
    }

    public void extend(IntList list) {
        for (int value : list) {
            append(value);
        }
        pointer += list.size();
    }

}
