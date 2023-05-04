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

        assertEquals(11, table.size(), "size is not 11");

        for (int i = 0; i < 10; i++) {
            assertEquals(i, table.get(Integer.toString(i), -1), String.format("key %s is not associated to value %s", i, i));
        }
        assertEquals(314, table.get("10", -1), "key 10 is not associated to value 314");
        assertEquals(-1, table.get("11", -1), "default value is not returned when key is not found");

        table.set("10", 2718);
        assertEquals(2718, table.get("10", -1), "key 10 is not associated to value 2718 (value not overwritten)");
        assertEquals(11, table.size(), "size is not 11");

        Integer deletedValue = table.delete("10");
        assertEquals(10, table.size(), "size is not 11");
        assertEquals(2718, deletedValue, "deleted value is not returned");

        for (int i = 0; i < 20; i++) {
            if (i < 10) {
                assertTrue(table.contains(Integer.toString(i)));
            } else {
                assertFalse(table.contains(Integer.toString(i)));
            }
        }

        table.set("", 100);
        assertEquals(100, table.get("", -1), "empty string did not work as a key");
        assertTrue(table.contains(""), "empty string did not work as a key");

        deletedValue = table.delete("wrong key");
        assertEquals(null, deletedValue, "deleted value of wrong key is not null");

    }
}
