package chus.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxPriorityQueue<K extends Comparable<K>> {
    private List<K> a;

    public MaxPriorityQueue() {
    }

    public MaxPriorityQueue(int i) {
        a = new ArrayList<>(10);
    }

    public MaxPriorityQueue(K[] a) {
        this.a = new ArrayList<>(Arrays.asList(a));
    }

    public boolean isEmpty() {
        return a == null || a.isEmpty();
    }

    public int size() {
        if (a == null) {
            return 0;
        }

        return a.size();
    }

    public K max() {
        if (isEmpty()) {
            return null;
        }

        K max = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            if (max.compareTo(a.get(i)) < 0) {
                max = a.get(i);
            }
        }

        return max;
    }

    public K delMax() {
        if (isEmpty()) {
            return null;
        }

        K max = a.get(0);
        int maxInd = 0;
        for (int i = 1; i < a.size(); i++) {
            if (max.compareTo(a.get(i)) < 0) {
                max = a.get(i);
                maxInd = i;
            }
        }

        a.remove(maxInd);
        return max;
    }

    public void insert(K i) {
        a.add(0, i);
    }

}
