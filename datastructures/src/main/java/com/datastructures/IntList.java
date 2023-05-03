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

    }

    public int size() {
        return 0;
    }

    public int get(int index) {
        return 0;
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
