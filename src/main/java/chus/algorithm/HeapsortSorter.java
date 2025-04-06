package chus.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapsortSorter<T extends Comparable<T>> extends Sorter<T> {
    int N;

    @Override
    public void sort(T[] a) {
        int n = a.length;
        N = n;

        List<T> b = new ArrayList<>(n + 1);
        b.add(null);
        b.addAll(Arrays.asList(a));

        for (int k = n / 2; k >= 1; k--) {
            sink(b, k, n);
        }

        while (n > 1) {
            exch(b, 1, n--);
            sink(b, 1, n);
        }

        for (int i = 1; i <= N; i++) {
            a[i - 1] = delMax(b);
        }
    }

    public T delMax(List<T> a) {
        T max = a.get(1);

        exch(a, 1, N--);
        a.set(N + 1, null);
        sink(a, 1, N);

        a.remove(N + 1);

        return max;
    }

    private void sink(List<T> a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;

            if (j < n && less(a, j, j + 1)) {
                j++;
            }

            if (!less(a, k, j)) {
                break;
            }

            exch(a, k, j);

            k = j;
        }
    }

    protected boolean less(List<T> a, int v, int w) {
        return a.get(v).compareTo(a.get(w)) < 0;
    }

    protected void exch(List<T> a, int i, int j) {
        T t = a.get(i);
        a.set(i, a.get(j));
        a.set(j, t);
    }

}