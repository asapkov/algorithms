package chus.algorithm;

import java.util.Random;

public class QuickSorter<T extends Comparable<T>> extends Sorter<T> {
    private Random rnd = new Random();

    @Override
    public void sort(T[] a) {
        shuffleArray(a);
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

    private void shuffleArray(T[] ar) {
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);

            T a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}