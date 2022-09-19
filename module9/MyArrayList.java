package module9;

import java.util.Arrays;

public class MyArrayList<T> extends MyList {
    private Object[] data = new Object[0];

    public void add(T value) {
        Object[] newData = Arrays.copyOf(data, data.length + 1);
        newData[newData.length - 1] = value;
        data = newData;
    }

    @Override public void clear() {
        data = new Object[0];
    }

    @Override public Object get(int index) throws IndexOutOfBoundsException {
        if(data.length > index && index >= 0) {
            return data[index];
        } else throw new IndexOutOfBoundsException();
    }

    @Override public int size() {
        return data.length;
    }

    @Override public void remove(int index) throws IndexOutOfBoundsException {
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


}
