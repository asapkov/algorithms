package chus.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

class HeapsortSorterTest {
    @Test
    void sort_small_array_of_integers_and_check_that_it_is_sorted() {
        HeapsortSorter<Integer> is = new HeapsortSorter<>();

        Integer[] a = new Integer[] { 4, 5, 6, 2, 8, 9, 22, 40, 12, 0, 33 };
        Integer[] sa = new Integer[] { 0, 2, 4, 5, 6, 8, 9, 12, 22, 33, 40 };

        is.sort(a);

        Arrays.asList(a).forEach(System.out::println);

        assertThat(is.isSorted(a)).isTrue();
        assertThat(a).isEqualTo(sa);
    }
}
