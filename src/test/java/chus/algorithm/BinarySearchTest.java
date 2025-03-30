package chus.algorithm;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class BinarySearchTest {
    private final int[] arr = { 4, 7, 19, 23, 45, 46, 50, 60, 71 };
    private final int[] unsortedArr = { 4, 45, 7, 19, 23, 15, 45, 46, 50, 2, 60, 0, 71 };

    @Test
    void search_for_value_inside_array_finds_right_index() {
        int result = BinarySearch.search(23, arr);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void search_for_the_first_value_in_array_finds_right_index_0() {
        int result = BinarySearch.search(4, arr);
        assertThat(result).isZero();
    }

    @Test
    void search_for_the_first_value_in_array_finds_right_index_8() {
        int result = BinarySearch.search(71, arr);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void search_for_the_value_not_present_in_array() {
        int result = BinarySearch.search(99, arr);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void search_for_the_value_when_array_is_not_sorted() {
        int result = BinarySearch.search(45, unsortedArr);
        // This is incorrect index, of course, but we test that algorithm doesn't fail
        // when the array is not sorted.
        assertThat(result).isEqualTo(6); 
    }
}
