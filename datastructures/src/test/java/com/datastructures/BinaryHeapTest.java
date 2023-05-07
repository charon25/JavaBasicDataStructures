package com.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BinaryHeapTest {
    
    @Test
    public void testExtractMin() {
        BinaryHeap heap = new BinaryHeap();
        assertEquals(0, heap.size(), "binary heap is not empty");

        for (int i = 19; i >= 10; i--) {
            heap.insert(Integer.toString(i), i);
        }
        for (int i = 0; i < 10; i++) {
            heap.insert(Integer.toString(i), i);
        }

        assertEquals(20, heap.size(), "binary heap is not empty");


        for (int i = 0; i < 20; i++) {
            assertEquals(Integer.toString(i), heap.getMin(), String.format("element with priority %s was not at index %s", i, i));
            assertEquals(Integer.toString(i), heap.extractMin(), String.format("element with priority %s was not extracted at index %s", i, i));
        }
    }

    @Test
    public void testInsertAndDecreaseKey() {
        BinaryHeap heap = new BinaryHeap();
        for (int i = 0; i < 10; i++) {
            heap.insert(Integer.toString(i), 2 * i);
        }

        heap.insert("-1", -1);

        assertEquals("-1", heap.extractMin(), "-1 was not put at the front");

        heap.decreaseKey("9", -1);

        assertEquals("9", heap.extractMin(), "9 was not put at the front after decrease");

    }


}
