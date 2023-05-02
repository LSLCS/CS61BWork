public class LinkedListDeque<T> {
    private class Alloc {
        private T item;
        private Alloc prev;
        private Alloc next;

        public Alloc(T item, Alloc prev, Alloc next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        public Alloc() {
        }
    }

    private Alloc sentinel;
    private int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Alloc();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        sentinel.next = new Alloc(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev = new Alloc(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
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
        Alloc toPrint = sentinel;
        for (int i = 0; i < size - 1; i++) {
            toPrint = toPrint.next;
            System.out.print(toPrint.item + " ");
        }
        System.out.println(toPrint.next.item);
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return first;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return last;
    }

    public T get(int index) {
        if (isEmpty() || index > size || index < 0) {
            return null;
        }
        Alloc toGet = sentinel;
        for (int i = 0; i < index; i++) {
            toGet = toGet.next;
        }
        return toGet.next.item;
    }

    public T getRecursive(int index) {
        if (isEmpty() || index > size || index < 0) {
            return null;
        }
        return getAllocRecursive(index, sentinel.next).item;
    }

    private Alloc getAllocRecursive(int index, Alloc a) {
        if (index == 0) {
            return a;
        }
        return getAllocRecursive(index - 1, a.next);
    }

}
