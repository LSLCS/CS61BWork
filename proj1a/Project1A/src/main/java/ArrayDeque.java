public class ArrayDeque<T> {
    public static final int ARRAYLENGTHFORUSAGECHECK = 16;
    public static final int HUNDRED = 100;
    public static final int LOW_USAGE = 25;
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int arrayLength;
    private float arrayUsage;


    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        arrayLength = 8;
        nextFirst = 0;
        nextLast = 1;
        arrayUsage = 0;
    }

    private void resize(int newLength) {
        T[] newArray = (T[]) new Object[newLength];
        for (int i = 0; i < size; i++) {
            int arrayIndex;
            arrayIndex = (i + nextFirst + 1) >= arrayLength
                    ? (i + nextFirst + 1 - arrayLength) : (i + nextFirst + 1);
            newArray[i] = items[arrayIndex];
        }
        arrayLength = newLength;
        nextFirst = newLength - 1;
        nextLast = size;
        items = newArray;
    }

    private void checkArrayUsage() {
        if (arrayLength >= ARRAYLENGTHFORUSAGECHECK) {
            arrayUsage = size * HUNDRED / arrayLength;
            if (arrayUsage < LOW_USAGE) {
                resize(arrayLength / 2);
            }
        }
    }

    public void addFirst(T item) {
        if (size == arrayLength) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1) < 0
                ? (arrayLength + nextFirst - 1) : (nextFirst - 1);
        size += 1;
    }

    public void addLast(T item) {
        if (size == arrayLength) {
            resize(size * 2);
        }

        items[nextLast] = item;
        nextLast = (nextLast + 1) == arrayLength
                ? (nextLast + 1 - arrayLength) : (nextLast + 1);
        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;

    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        for (int i = 1; i <= size; i++) {
            int printIndex;
            printIndex = (i + nextFirst) >= arrayLength
                    ? (i + nextFirst - arrayLength) : (i + nextFirst);
            System.out.print(items[printIndex]);
            if (i != size) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        int firstIndex;
        firstIndex = (nextFirst + 1) >= arrayLength
                ? (nextFirst + 1 - arrayLength) : (nextFirst + 1);
        size -= 1;
        T firstItem = items[firstIndex];
        items[firstIndex] = null;
        nextFirst = firstIndex;

        checkArrayUsage();
        return firstItem;
    }



    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        int lastIndex;
        lastIndex = (nextLast - 1) < 0
                ? (arrayLength + nextLast - 1) : (nextLast - 1);
        size -= 1;
        T lastItem = items[lastIndex];
        items[lastIndex] = null;
        nextLast = lastIndex;

        checkArrayUsage();
        return lastItem;
    }

    public T get(int index) {
        if (isEmpty() || index > size || index < 0) {
            return null;
        }
        int getArrayIndex;
        getArrayIndex = (nextFirst + index + 1) >= arrayLength
                ? (nextFirst + index + 1 - arrayLength) : (nextFirst + index + 1);
        return items[getArrayIndex];
    }



}
