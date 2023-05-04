package com.datastructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringHashTableTest {
    @Test
    public void testBasicOperationsInt() {
        StringHashTable<Integer> table = new StringHashTable<>();
        assertEquals(0, table.size(), "new hash table is not empty");

        for (int i = 0; i < 10; i++) {
            table.set(Integer.toString(i), i);
        }

        table.set("10", 314);

        for (int i = 0; i < 10; i++) {
            assertEquals(i, table.get(Integer.toString(i), -1), String.format("key %s is not associated to value %s", i, i));
        }
        assertEquals(314, table.get("10", -1), "key 10 is not associated to value 314");
        assertEquals(-1, table.get("11", -1), "default value is not returned when key is not found");

        table.delete("10");

        for (int i = 0; i < 20; i++) {
            if (i < 10) {
                assertTrue(table.contains(Integer.toString(i)));
            } else {
                assertFalse(table.contains(Integer.toString(i)));
            }
        }


    }
}
