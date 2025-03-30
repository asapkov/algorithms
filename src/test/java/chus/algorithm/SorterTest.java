package chus.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SorterTest {
    class DummySorter<T extends Comparable<T>> extends Sorter<T> {
        @Override
        public void sort(T[] a) {
            return;
        }
    }

    @Test
    void test_is_sorted_that_it_correctly_recognises_sorted_or_unsorted_collections() {
        Integer[] sorted = new Integer[] { 0, 1, 2, 3, 4 };
        Integer[] unsorted = new Integer[] { 4, 1, 2, 5, 3 };

        DummySorter<Integer> ds = new DummySorter<>();

        assertThat(ds.isSorted(sorted)).isTrue();
        assertThat(ds.isSorted(unsorted)).isFalse();
    }

}
