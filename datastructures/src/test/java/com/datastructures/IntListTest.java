package com.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntListTest {

    @Test
    void testBasicOperations() {
        IntList list = new IntList();
        assertEquals(0, list.size(), "new list is not empty");
        for (int i = 0; i < 10; i++) {
            list.append(i);
        }
        assertEquals(10, list.size(), "list does not have 10 elements");
        for (int i = 0; i < 10; i++) {
            assertEquals(i, list.get(i), String.format("element %s is not %s", i, i));
        }
        for (int i = 1; i < 10; i++) {
            assertEquals(10 - i, list.get(-i), String.format("element %s is not %s", -i, 10 - i));
        }

        int value = list.pop();
        assertEquals(9, value, "popped value is not 9");
        value = list.pop(0);
        assertEquals(0, value, "popped value is not 0");
        list.remove(4);
        assertEquals(7, list.size(), "list did not pop 2 elements");
        for (int i = 1; i < 0; i++) {
            if (i == 4)
                continue;
            assertEquals(i, list.get(i), String.format("element %s is not %s", i, i));
        }

        list.set(0, 100);
        assertEquals(100, list.get(0), "element 0 is not 100");
        list.set(-1, 314);
        assertEquals(314, list.get(-1), "element 0 is not 100");

        list.remove(314159);
    }

    @Test
    void testLargeSize() {
        IntList list = new IntList();

        final int N = 1_000_000;

        for (int i = 0; i < N; i++) {
            list.append(i);
        }

        for (int i = 0; i < N; i++) {
            assertEquals(i, list.get(i), String.format("element %s is not %s", i, i));
        }
    }

    @Test
    void testExtend() {
        IntList list = new IntList(new int[] {3, 14, 15});
        IntList list2 = new IntList();

        for (int i = 0; i < 100; i++) {
            list2.append(i);
        }

        list.extend(list2);
        assertEquals(list.get(0), 3, "element 0 is not 3");
        assertEquals(list.get(1), 14, "element 1 is not 14");
        assertEquals(list.get(2), 15, "element 2 is not 15");
        for (int i = 0; i < 100; i++) {
            assertEquals(i, list.get(i + 3), String.format("element %s is not %s", i + 3, i));
        }
    }

    @Test
    void testErrors() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            IntList list = new IntList();
            list.append(2);
            list.get(1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            IntList list = new IntList();
            list.append(2);
            list.get(-2);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            IntList list = new IntList();
            list.append(2);
            list.pop(1);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            IntList list = new IntList();
            list.append(2);
            list.pop(-2);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            IntList list = new IntList();
            list.append(2);
            list.set(1, 0);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            IntList list = new IntList();
            list.append(2);
            list.set(-2, 0);
        });
    }

    @Test
    public void testIteration() {
        IntList list = new IntList();
        for (int i = 0; i < 100; i++) {
            list.append(5 * i);
        }

        int index = 0;
        for (int integer : list) {
            assertEquals(integer, 5 * index, String.format("element %s is not %s", index, integer));
            index++;
        }
    }

    @Test
    public void testConstrucLargeArray() {
        int[] array = new int[100];
        IntList list = new IntList(array);
        assertEquals(100, list.size(), "size is not 100");
    }

}
