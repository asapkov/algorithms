package chus.algorithm;

import java.util.Random;

public class QuickThreeWaySorter<T extends Comparable<T>> extends Sorter<T> {
    private Random rnd = new Random();

    @Override
    public void sort(T[] a) {
        shuffleArray(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(T[] a, int lo, int hi) {
        if (hi < lo) {
            return;
        }

        int lt = lo;
        int i = lo + 1;
        int gt = hi;

        T v = a[lo];

        while (i <= gt) {
            int cmp = a[i].compareTo(v);

            if (cmp < 0) {
                exch(a, lt++, i++);
            } else if (cmp > 0) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
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