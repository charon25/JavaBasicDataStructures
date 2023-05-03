package com.datastructures;

public class IntList {

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

    public void append(int value) {
        if (pointer < currentSize - 1) {
            elements[pointer] = value;
            pointer++;
        } else {
            int[] newElements = new int[2 * currentSize];
            for (int i = 0; i < currentSize; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;

            currentSize *= 2;
            pointer++;
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

    public int pop() {
        return pop(-1);
    }

    public int pop(int index) {
        return 0;
    }

    public void remove(int index) {

    }

    public void extend(IntList list) {

    }

}
