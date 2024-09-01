package com.learn.java.junit5.hamcrest;

import org.assertj.core.api.HamcrestCondition;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HamcrestTest {

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(list, hasSize(5));
        assertThat(list, hasItems(1, 2, 3, 4, 5));
        assertThat(list, everyItem(isA(Integer.class)));
        assertThat(list, everyItem(greaterThan(0)));
        assertThat(list, everyItem(lessThan(6)));
        assertThat("", isEmptyString());
        assertThat("ABCDEF", startsWith("ABC"));
        assertThat("ABCDEF", endsWith("DEF"));
        assertThat("ABCDEF", not("DFGH"));
        assertThat("ABCDEF", containsString("BCD"));

    }
}
