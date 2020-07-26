public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int REFACTOR = 2;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 0;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if ((nextFirst + 1) % items.length + size < items.length)
            System.arraycopy(items, (nextFirst + 1) % items.length, a, 0, size);
        else {
            System.arraycopy(items, (nextFirst + 1) % items.length, a, 0, items.length - (nextFirst + 1) % items.length);
            System.arraycopy(items, 0, a, items.length - (nextFirst + 1) % items.length, size + (nextFirst + 1) % items.length - items.length);
        }
        items = a;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    public void addFirst(T x) {
        if (size == items.length) {
            resize(items.length * REFACTOR);
        }
        items[nextFirst] = x;
        if (size == 0 && nextFirst == nextLast) {
            nextLast++;
            nextLast %= items.length;
        }
        nextFirst--;
        if (nextFirst < 0)
            nextFirst += items.length;
        size++;
    }

    public void addLast(T x) {
        if (size == items.length){
            resize(items.length * REFACTOR);
        }
        items[nextLast] = x;
        if (size == 0 && nextFirst == nextLast){
            nextFirst--;
            if (nextFirst < 0)
                nextFirst += items.length;
        }
        nextLast++;
        nextLast %= items.length;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int index = nextFirst;
        for (int i = 0; i < size; i++) {
            index++;
            index %= items.length;
            System.out.print(items[index].toString() + " ");
        }
    }

    public T removeFirst() {
        if (size == items.length / 4) {
            resize(items.length / REFACTOR);
        }
        nextFirst++;
        nextFirst %= items.length;
        T x = items[nextFirst];
        items[nextFirst] = null;
        size = size - 1;
        return x;
    }

    public T removeLast() {
        if (size == items.length / 4) {
            resize(items.length / REFACTOR);
        }
        nextLast--;
        if (nextLast < 0)
            nextLast += items.length;
        T x = items[nextLast];
        items[nextLast] = null;
        size = size - 1;
        return x;
    }

    public T get(int i) {
        return items[(nextFirst + 1 + i) % size];
    }

//    public static void main(String[] args) {
//        ArrayDeque<Integer> L = new ArrayDeque<>();
//        L.addFirst(5);
//        L.addLast(10);
//        L.addLast(15);
//        L.addLast(20);
//        L.addFirst(2);
//        L.addLast(30);
//        L.addLast(40);
//        L.addLast(45);
//        L.addLast(50);
//        System.out.println(L.size());
//        L.printDeque();
//        System.out.println("");
//        System.out.println(L.removeLast());
//        System.out.println(L.size());
//        L.printDeque();
//        System.out.println("");
//        System.out.println(L.removeFirst());
//        System.out.println(L.size());
//        L.printDeque();
//        System.out.println("");
//        System.out.println(L.get(1));
//        System.out.println(L.removeLast());
//        L.printDeque();
//        System.out.println("");
//        System.out.println(L.removeLast());
//        L.printDeque();
//        System.out.println("");
//        System.out.println(L.removeLast());
//        L.printDeque();
//        System.out.println("");
//        System.out.println(L.nextFirst);
//        System.out.println(L.nextLast);
//        System.out.println(L.removeFirst());
//        L.printDeque();
//        System.out.println("");
//        System.out.println(L.size());
//        System.out.println(L.nextFirst);
//        System.out.println(L.nextLast);
//        System.out.println(L.removeLast());
//        L.printDeque();
//        System.out.println("");
//        System.out.println(L.size());
//        System.out.println(L.nextFirst);
//        System.out.println(L.nextLast);
//        System.out.println(L.removeFirst());
//        L.printDeque();
//    }

}
