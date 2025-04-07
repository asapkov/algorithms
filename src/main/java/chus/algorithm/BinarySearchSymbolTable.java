package chus.algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchSymbolTable<K extends Comparable<K>, V> {
    private List<K> keys;
    private List<V> vals;
    private int n;

    public BinarySearchSymbolTable() {
        this(0);
    }

    public BinarySearchSymbolTable(int i) {
        keys = new ArrayList<>(i);
        vals = new ArrayList<>(i);
    }

    public int size() {
        return n;
    }

    public int rank(K key) {
        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys.get(mid));

            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public void put(K key, V val) {
        int i = rank(key);

        if (i < n && keys.get(i).compareTo(key) == 0) {
            vals.set(i, val);
            return;
        }

        keys.add(null);
        vals.add(null);

        for (int j = n; j > i; j--) {
            keys.set(j, keys.get(j - 1));
            vals.set(j, vals.get(j - 1));
        }

        keys.set(i, key);
        vals.set(i, val);

        n++;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public V get(K key) {
        if (isEmpty()) {
            return null;
        }

        int i = rank(key);
        if (i < n && keys.get(i).compareTo(key) == 0) {
            return vals.get(i);
        }

        return null;
    }

    public Iterator<K> keys() {
        return keys.iterator();
    }

    public void delete(K key) {
        Integer i = rank(key);

        if (keys.get(i).compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < n - 1; j++) {
            keys.set(j, keys.get(j + 1));
            vals.set(j, vals.get(j + 1));
        }

        keys.remove(n - 1);
        vals.remove(n - 1);

        n--;
    }

}
