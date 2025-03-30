package chus.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnionFindTest {
    @Test
    void initialize_N_sites_then_check_the_params() {
        UnionFind uf = new UnionFind(100);

        assertThat(uf.count()).isEqualTo(100);

        // name of the site is equal to its index in the array (just for simplicity)
        assertThat(uf.find(50)).isEqualTo(50);

        // every site is self connected from the start (i.e. connections are reflexive)
        assertThat(uf.connected(2, 2)).isTrue();

        // every site is not connected to another sites from the start
        assertThat(uf.connected(1, 2)).isFalse();

        int oldCount = uf.count();
        uf.union(1, 2);
        assertThat(uf.connected(1, 2)).isTrue();
        assertThat(uf.count()).isEqualTo(oldCount - 1);
    }
}
