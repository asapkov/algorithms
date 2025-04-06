package chus.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class SequentialSearchSymbolTableTest {
    @Test
    void create_symbol_table_and_check_that_its_created_correctly() {
        SequentialSearchSymbolTable<String, Integer> ssst = new SequentialSearchSymbolTable<>();

        String[] st = new String[] { "S", "E", "A", "R", "C", "H", "E", "X", "A", "M", "P", "L", "E" };
        Integer[] in = new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };

        for (int i = 0; i < st.length; i++) {
            ssst.put(st[i], in[i]);
        }

        assertThat(ssst.size()).isEqualTo(10);
        assertThat(ssst.get("E")).isEqualTo(12);
        assertThat(ssst.get("G")).isNull();

        Iterator<String> it = ssst.keys();
        String[] keys = new String[10];
        int i = 0;

        while (it.hasNext()) {
            keys[i++] = it.next();
        }

        assertThat(keys[0]).isEqualTo("L");
        assertThat(keys[9]).isEqualTo("S");

        ssst.delete("X");
        assertThat(ssst.get("X")).isNull();
        ssst.delete("L");
        assertThat(ssst.get("L")).isNull();
        assertThat(ssst.get("S")).isZero();

    }

}
