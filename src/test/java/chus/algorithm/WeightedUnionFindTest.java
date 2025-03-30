package chus.algorithm;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WeightedUnionFindTest {

    @Test
    void initialize_N_sites_then_check_the_params() {
        WeightedUnionFind wuf = new WeightedUnionFind(100);

        assertThat(wuf.count()).isEqualTo(100);

        // name of the site is equal to its index in the array (just for simplicity)
        assertThat(wuf.find(50)).isEqualTo(50);

        // every site is self connected from the start (i.e. connections are reflexive)
        assertThat(wuf.connected(2, 2)).isTrue();

        // every site is not connected to another sites from the start
        assertThat(wuf.connected(1, 2)).isFalse();

        int oldCount = wuf.count();
        wuf.union(1, 2);
        assertThat(wuf.connected(1, 2)).isTrue();
        assertThat(wuf.count()).isEqualTo(oldCount - 1);

        int pSize = wuf.size(1);
        int qSize = wuf.size(3);
        assertThat(pSize).isEqualTo(2);
        assertThat(qSize).isEqualTo(1);

        wuf.union(1, 3);
        assertThat(wuf.size(1)).isEqualTo(3);
        assertThat(wuf.size(3)).isEqualTo(1);
        assertThat(wuf.size(2)).isEqualTo(1);
    }
}
