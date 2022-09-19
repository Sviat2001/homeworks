package module9;

import java.util.Arrays;

public class MyStack<T> {
    private Object[] data = new Object[0];

    public void push(T value) {
        Object[] newData = Arrays.copyOf(data, data.length + 1);
        newData[newData.length - 1] = value;
        data = newData;
    }

    public void clear() {
        data = new Object[0];
    }

    public int size() {
        return data.length;
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index > data.length - 1) {
            throw new IndexOutOfBoundsException();
        }

        while(index < data.length - 1) {
            data[index] = data[index + 1];
            index++;
        }

        Object[] newData = Arrays.copyOf(data, data.length - 1);
        data = newData;
    }

    public Object pop() {
        Object last = peek();
        try {
            remove(data.length - 1);
        } catch (IndexOutOfBoundsException ex) {

        }

        return last;
    }

    public Object peek() {
        if(data.length > 0) {
            return data[data.length - 1];
        } else {
            return null;
        }
    }

}
