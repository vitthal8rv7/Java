package com.learn.java.junit5.assertj;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class AssertjTest {

    @Test
    public void testAssertj() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(list).containsExactly(1, 2, 3, 4, 5);
        assertThat(list).hasSize(5);
        assertThat(list)
                .hasSize(5)
                .contains(1, 2)
                .allMatch( everyElement -> everyElement < 6)
                .allMatch( everyElement -> everyElement > 0)
                .noneMatch(everyElement -> everyElement < 0);
        assertThat("ABCDEF").isNotEmpty();
        assertThat("").isEmpty();
        assertThat("ABCDEF")
                .contains("BCD")
                .startsWith("ABC")
                .endsWith("DEF");

    }

}
