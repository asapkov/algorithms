package chus.algorithm;

import java.util.ArrayList;
import java.util.List;

public class MaxPriorityQueue<K extends Comparable<K>> {
    private List<K> a;
    private int n = 0;

    public MaxPriorityQueue(K[] a) {
        this.a = new ArrayList<>();

        this.a.add(null);
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public K max() {
        return a.get(1);
    }

    public K delMax() {
        K max = a.get(1);

        exch(1, n--);
        a.set(n + 1, null);
        sink(1);

        a.remove(n + 1);

        return max;
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;

            if (j < n && less(j, j + 1)) {
                j++;
            }

            if (!less(k, j)) {
                break;
            }

            exch(k, j);

            k = j;
        }
    }

    public void insert(K i) {
        n++;
        a.add(i);
        swim(n);
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    protected boolean less(int v, int w) {
        return a.get(v).compareTo(a.get(w)) < 0;
    }

    protected void exch(int i, int j) {
        K t = a.get(i);
        a.set(i, a.get(j));
        a.set(j, t);
    }

}
