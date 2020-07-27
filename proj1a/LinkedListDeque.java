public class LinkedListDeque<T> {
    private StuffNode sentinel;
    private int size;
    private T stuff;

    private class StuffNode {
        private T item;
        private StuffNode prev;
        private StuffNode next;

        public StuffNode(T i, StuffNode m, StuffNode n) {
            item = i;
            prev = m;
            next = n;
        }
    }

    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        size = 0;
    }

    public void addFirst(T x) {
        if (size == 0) {
            sentinel = new StuffNode(stuff, null, null);
            sentinel.next = new StuffNode(x, sentinel, sentinel);
            sentinel.prev = sentinel.next;
            size = 1;
        } else {
            sentinel.next = new StuffNode(x, sentinel, sentinel.next);
            sentinel.next.next.prev = sentinel.next;
            size += 1;
        }
    }

    public void addLast(T x) {
        size += 1;
        sentinel.prev = new StuffNode(x, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode p = sentinel;
        while (p.next != null && p.next.item != stuff) {
            p = p.next;
            System.out.print(p.item.toString() + " ");
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return first;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return last;
    }

    public T get(int index) {
        StuffNode p = sentinel;
        int count = 0;
        while(p.next.item != stuff && p.next != null) {
            p = p.next;
            if (count == index) {
                return p.item;
            } else {
                count++;
            }
        }
        return null;
    }

    public T getRecursive(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return helper(sentinel, index);
    }

    private T helper(StuffNode p, int index) {
        if (index == 0) {
            return p.next.item;
        }
        return helper(p.next, index - 1);
    }
}