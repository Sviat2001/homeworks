package module9;

import java.util.Arrays;

public class MyQueue<T> {
    private Object[] data = new Object[0];

    public void add(T value) {
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

    public Object peek() {
        if(data.length > 0) {
            return data[0];
        } else {
            return null;
        }
    }

    public Object poll() {
        Object first = peek();
        remove(0);
        return first;
    }
}
