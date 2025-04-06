package chus.algorithm;

public class HeapsortSorter<T extends Comparable<T>> extends Sorter<T> {
    @Override
    public void sort(T[] a) {
        int n = a.length - 1;
        for (int k = n / 2; k >= 1; k--)
            sink(a, k, n);
        while (n > 1) {
            exch(a, 1, n--);
            sink(a, 1, n);
        }
    }

    private void sink(T[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(a, j, j + 1))
                j++;
            if (!less(a, k, j))
                break;
            exch(a, k, j);
            k = j;
        }
    }

    private boolean less(T[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    @Override
    protected void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}