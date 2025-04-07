package chus.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchSymbolTableTest {
    BinarySearchSymbolTable<String, Integer> bsst;

    final String[] st = new String[] { "S", "E", "A", "R", "C", "H", "E", "X", "A", "M", "P", "L", "E" };
    final Integer[] in = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

    @BeforeEach
    void before_each() {
        bsst = new BinarySearchSymbolTable<>(13);
    }

    void fill() {
        for (int i = 0; i < st.length; i++) {
            bsst.put(st[i], in[i]);
        }
    }

    @Test
    void create_BSST_and_check_that_it_is_created_correctly() {
        assertThat(bsst).isNotNull();
        assertThat(bsst.size()).isZero();
        assertThat(bsst.rank("G")).isZero();
        assertThat(bsst.isEmpty()).isTrue();

        fill();

        assertThat(bsst.size()).isEqualTo(10);
        assertThat(bsst.get("E")).isEqualTo(12);

    }

    @Test
    void check_the_sorting_algorithm() {
        fill();
        Iterator<String> it = bsst.keys();

        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("A");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("C");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("E");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("H");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("L");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("M");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("P");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("R");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("S");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("X");
    }

    @Test
    void check_the_deletion() {
        fill();
        bsst.delete("S");
        Iterator<String> it = bsst.keys();

        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("A");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("C");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("E");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("H");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("L");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("M");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("P");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("R");
        assertThat(it.hasNext()).isTrue();
        assertThat(it.next()).isEqualTo("X");
        assertThat(bsst.size()).isEqualTo(9);
    }
}
