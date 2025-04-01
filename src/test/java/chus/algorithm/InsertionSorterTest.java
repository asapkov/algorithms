package chus.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class InsertionSorterTest {
    @Test
    void sort_small_array_of_integers_and_check_that_it_is_sorted() {
        InsertionSorter<Integer> is = new InsertionSorter<>();

        Integer[] a = new Integer[] { 4, 5, 6, 2, 8, 9, 22, 40, 12, 0, 33 };
        Integer[] sa = new Integer[] { 0, 2, 4, 5, 6, 8, 9, 12, 22, 33, 40 };

        is.sort(a);

        assertThat(is.isSorted(a)).isTrue();
        assertThat(a).isEqualTo(sa);
    }
}
