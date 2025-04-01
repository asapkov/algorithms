package chus.algorithm;

public abstract class Sorter<T extends Comparable<T>> {
    public abstract void sort(T[] a);

    public boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
