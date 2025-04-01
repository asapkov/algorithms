package chus.algorithm;

import java.util.Arrays;

public class MergeSorter<T extends Comparable<T>> extends Sorter<T> {
    private T[] aux;

    @Override
    public void sort(T[] a) {
        aux = Arrays.copyOf(a, a.length);
        int len = a.length;

        for (int sz = 1; sz < len; sz = sz + sz) {
            for (int lo = 0; lo < len - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, len - 1));
            }
        }
    }

    private void merge(T[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        System.arraycopy(a, lo, aux, lo, hi - lo + 1);

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

    }
}