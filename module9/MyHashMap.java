package module9;

import java.util.Arrays;

public class MyHashMap<K, V> {
    private final int SIZE = 16;
    private final Node[] table;
    private int currentMapSize = 0;

    public MyHashMap() {
        table = new Node[SIZE];
    }

    public void put(K key, V value) {
        int hash = key.hashCode() & (SIZE - 1);
        Node<K, V> entry = table[hash];

        if (entry == null) {
            table[hash] = new Node<>(key, value);
        } else {
            while (entry.next != null) {
                if (entry.getKey() == key) {
                    entry.setValue(value);
                    return;
                }
                entry = entry.next;
            }

            if (entry.getKey() == key) {
                entry.setValue(value);
                return;
            }
            entry.next = new Node<K, V>(key, value);
        }
        currentMapSize++;
    }

    public V get(K key) {
        int hash = key.hashCode() & (SIZE - 1);
        Node<K, V> entry = table[hash];

        if (entry == null) {
            return null;
        }

        while (entry != null) {
            if (entry.getKey() == key) {
                return entry.getValue();
            }
            entry = entry.next;
        }
        return null;
    }

    public void remove(K key) {
        int hash = key.hashCode() % SIZE;
        Node<K, V> entry = table[hash];
        Node<K, V> prev = entry;

        if (entry.getKey() == key) {
            table[hash] = entry.next;
            entry.next = null;
        }

        entry = entry.next;

        while (entry != null) {
            if (entry.getKey() == key) {
                prev.next = entry.next;
                entry.next = null;
            }
            prev = entry;
            entry = entry.next;
        }
        currentMapSize--;
    }

    public void clear() {
        Arrays.fill(table, null);
        currentMapSize = 0;
    }

    public int size() {
        return currentMapSize;
    }


    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }


        public void setKey(K key) {
            this.key = key;
        }
    }

}
