package chus.algorithm;

public class UnionFind {
    private int[] id;
    private int count;

    public UnionFind(int count) {
        this.count = count;
        this.id = new int[count];

        for (int i = 0; i < count; i++) {
            id[i] = i;
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

        id[pRoot] = qRoot;
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
