package module9;

public class MyLinkedList <T> extends MyList{

    Node<T> first = new Node<>(null, null, null);
    private int listSize = 0;

    private static class Node<T> {
        MyLinkedList.Node<T> prev;
        T item;
        MyLinkedList.Node<T> next;


        Node(MyLinkedList.Node<T> prev, T element, MyLinkedList.Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

    }

    public void add(T value) {
        if(listSize == 0) {
            first.item = value;
        } else if(listSize > 0) {
            Node<T> currentItem = first;
            for(int i = 0; i < listSize - 1; i++) {
                currentItem = currentItem.next;
            }
            currentItem.next = new Node<>(currentItem, value, null);
        }

        listSize++;
    }

    @Override public void remove(int index) throws IndexOutOfBoundsException  {
        if(index < 0 || index > listSize - 1) {
            throw new IndexOutOfBoundsException();
        }

        if(index == 0) {
            first = first.next;
            if(listSize == 1) {
                first = new Node<>(null, null, null);
            }
        } else if(index > 0) {
            Node<T> currentItem = first;
            for (int i = 0; i < index - 1; i++) {
                currentItem = currentItem.next;
            }
            currentItem.next = currentItem.next.next;
        }

        listSize--;
    }

    @Override public void clear() {
        first = new Node<>(null, null, null);
        listSize = 0;
    }

    @Override public int size() {
        return listSize;
    }

    @Override public T get(int index) throws IndexOutOfBoundsException  {
        if(index < 0 || index > listSize - 1) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> currentItem = first;
        for(int i = 0; i < index; i++) {
            currentItem = currentItem.next;
        }

        return currentItem.item;
    }


}
