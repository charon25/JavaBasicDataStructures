package com.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntLinkedListTest {

    @Test
    void testBasicOperations() {
        IntLinkedList list = new IntLinkedList();
        assertEquals(0, list.size(), "list is not empty");

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertEquals(10, list.size(), "list does not have 10 elements");

        int index = 0;
        for (int integer : list) {
            assertEquals(index, integer, String.format("elements %s is not %s", index, integer));
            index++;
        }

        list.remove(4);
        assertEquals(9, list.size(), "list does not have 10 elements");
        assertTrue(list.contains(3), "list does not contain 3");
        assertFalse(list.contains(4), "list still contain 4");
        assertTrue(list.contains(5), "list does not contain 5");
    }

}
