package chus.algorithm;

public class WeightedUnionFind {
    private int[] id; // sites' ids
    private int[] size; // corresponding tree's size
    private int count; // count of components

    int size(int p) {
        return size[p];
    }

    public WeightedUnionFind(int count) {
        this.count = count;
        this.id = new int[count];
        this.size = new int[count];

        for (int i = 0; i < count; i++) {
            this.id[i] = i;
            this.size[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }

        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }

        return p;
    }

}
