package chus.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MaxPriorityQueueTest {
    @Test
    void create_priority_queue_and_check_that_it_is_created_correclty() {
        MaxPriorityQueue<Integer> mpq = new MaxPriorityQueue<>();
        assertThat(mpq.isEmpty()).isTrue();
        assertThat(mpq.size()).isZero();
        assertThat(mpq.max()).isNull();
        assertThat(mpq.delMax()).isNull();

        Integer[] a = { 0, 1, 2, 3 };
        mpq = new MaxPriorityQueue<>(a);
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

        mpq = new MaxPriorityQueue<>(10);
        assertThat(mpq.isEmpty()).isTrue();
        assertThat(mpq.size()).isZero();
        assertThat(mpq.max()).isNull();
        assertThat(mpq.delMax()).isNull();
    }
}
