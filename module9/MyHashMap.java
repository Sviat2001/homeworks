package module9;

public class MyHashMap<K, V>{

    private Node<K, V> first = new Node<>(null, null, null);
    private int mapSize = 0;
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(K key, V value) {
        Node<K, V> buffer = first;
        if(hasKey(key)) {
            while(buffer.next != null) {
                if(buffer.key.equals(key)) {
                    buffer.value = value;
                    mapSize++;
                    break;
                }
                buffer = buffer.next;
            }

            if(buffer.key.equals(key)) {
                buffer.value = value;
                mapSize++;
            }
        } else if(mapSize > 0) {
            while(buffer.next != null) {
                buffer = buffer.next;
            }

            buffer.next = new Node<K, V>(key, value, null);
            mapSize++;
        } else if(mapSize == 0) {
            first = new Node<K, V>(key, value, null);
            mapSize++;
        }
    }

    private boolean hasKey(K key) {
        Node<K, V> buffer = first;
        while(buffer.next != null) {
            if (buffer.key.equals(key)) {
                return true;
            }
            buffer = buffer.next;
        }

        if(buffer.key != null && buffer.key.equals(key)) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        first = new Node<>(null, null, null);
        mapSize = 0;
    }


    public int size() {
        return mapSize;
    }

    public void remove(K key) {
        if(hasKey(key)) {
            Node<K, V> buffer = first;
            Node<K, V> prev = null;
            while(buffer.next != null) {
                if (buffer.key.equals(key)) {
                    if(prev == null) {
                        first = first.next;
                    } else {
                        prev.next = buffer.next;
                    }

                    mapSize--;
                }
                prev = buffer;
                buffer = buffer.next;
            }

            if(buffer.key != null && buffer.key.equals(key)) {
                prev.next = null;
                mapSize--;
            }
        }
    }

    public Object get(K key) {
        if(hasKey(key)) {
            Node<K, V> buffer = first;
            while(buffer.next != null) {
                if (buffer.key.equals(key)) {
                    return buffer.value;
                }

                buffer = buffer.next;
            }

            if (buffer.key != null && buffer.key.equals(key)) {
                return buffer.value;
            }
        }

        return null;
    }



}
