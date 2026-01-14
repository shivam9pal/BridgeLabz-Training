package week03.gcrcodebase.stackandqueue;

import java.util.*;

public class CustomHashMap {

    static class Entry {
        int key, value;
        Entry next;

        Entry(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int SIZE = 5;
    private Entry[] table = new Entry[SIZE];

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Entry entry = new Entry(key, value);

        if (table[index] == null) {
            table[index] = entry;
        } else {
            Entry curr = table[index];
            while (curr.next != null) {
                if (curr.key == key) {
                    curr.value = value;
                    return;
                }
                curr = curr.next;
            }
            curr.next = entry;
        }
    }

    public Integer get(int key) {
        int index = hash(key);
        Entry curr = table[index];

        while (curr != null) {
            if (curr.key == key)
                return curr.value;
            curr = curr.next;
        }
        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        Entry curr = table[index], prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null)
                    table[index] = curr.next;
                else
                    prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();

        map.put(1, 10);
        map.put(2, 20);
        map.put(6, 60);
        // collision

        System.out.println("Key 2: " + map.get(2));
        System.out.println("Key 6: " + map.get(6));

        map.remove(2);
        System.out.println("Key 2 after removal: " + map.get(2));
    }
}

