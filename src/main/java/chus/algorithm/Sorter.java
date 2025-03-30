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

    private <V extends Comparable<V>> boolean less(V v, V w) {
        return v.compareTo(w) < 0;
    }

}
