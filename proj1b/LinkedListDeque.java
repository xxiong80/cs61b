public class LinkedListDeque<T>  implements Deque<T> {
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
        sentinel = new StuffNode(stuff, sentinel, sentinel);
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        if (size == 0) {
            sentinel.next = new StuffNode(x, sentinel, sentinel);
            sentinel.prev = sentinel.next;
            size = 1;
        } else {
            sentinel.next = new StuffNode(x, sentinel, sentinel.next);
            sentinel.next.next.prev = sentinel.next;
            size += 1;
        }
    }

    @Override
    public void addLast(T x) {
        if (size == 0) {
            sentinel.prev = new StuffNode(x, sentinel, sentinel);
            sentinel.next = sentinel.prev;
            size = 1;
        } else {
            sentinel.prev = new StuffNode(x, sentinel.prev, sentinel);
            sentinel.prev.prev.next = sentinel.prev;
            size += 1;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        StuffNode p = sentinel;
        while (p.next != null && p.next.item != stuff) {
            p = p.next;
            System.out.print(p.item.toString() + " ");
        }
    }

    @Override
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

    @Override
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

    @Override
    public T get(int index) {
        StuffNode p = sentinel;
        int count = 0;
        while (p.next.item != stuff && p.next != null) {
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
