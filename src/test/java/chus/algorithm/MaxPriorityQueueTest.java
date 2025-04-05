package chus.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MaxPriorityQueueTest {
    @Test
    void create_priority_queue_and_check_that_it_is_created_correclty() {
        Integer[] a = { 0, 1, 2, 3 };

        MaxPriorityQueue<Integer> mpq = new MaxPriorityQueue<>(a);
        System.out.println("a = " + a);
        assertThat(mpq.size()).isEqualTo(4);
        assertThat(mpq.isEmpty()).isFalse();
        assertThat(mpq.max()).isEqualTo(3);

        Integer max = mpq.delMax();
        assertThat(max).isEqualTo(3);
        assertThat(mpq.size()).isEqualTo(3);
        assertThat(mpq.max()).isEqualTo(2);
        assertThat(mpq.isEmpty()).isFalse();

        mpq.insert(5);
        assertThat(mpq.size()).isEqualTo(4);
        assertThat(mpq.max()).isEqualTo(5);
        assertThat(mpq.isEmpty()).isFalse();
    }
}
