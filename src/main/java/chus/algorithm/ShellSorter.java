package chus.algorithm;

public class ShellSorter<T extends Comparable<T>> extends Sorter<T> {

    @Override
    public void sort(T[] a) {
        int len = a.length;
        int h = 1;

        while (h < len / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

}
