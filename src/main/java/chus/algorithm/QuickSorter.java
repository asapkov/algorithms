package chus.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSorter<T extends Comparable<T>> extends Sorter<T> {

    @SuppressWarnings("unchecked")
    @Override
    public void sort(T[] a) {
        List<T> shuffled = Arrays.asList(a);
        Collections.shuffle(shuffled);
        a = Arrays.copyOf((T[]) shuffled.stream().toArray(), a.length);
        sort(a, 0, a.length - 1);
    }

    private void sort(T[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int j = partition(a, lo, hi);

        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(T[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        T v = a[lo];

        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }

            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }

}