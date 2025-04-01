package chus.algorithm;

public class InsertionSorter<T extends Comparable<T>> extends Sorter<T> {
    @Override
    public void sort(T[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}
