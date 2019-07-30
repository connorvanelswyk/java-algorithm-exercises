package com.github.connorvanelswyk.sort;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {

    final Solution solution = new Solution();

    int[] ints;
    int expected;

    @After
    public void after() {
        int actual = solution.solution(ints);
        log.debug("assertEquals({},{})", expected, actual);
        assertEquals(expected, actual);
    }

    @Test
    public void test_1() {
        ints = new int[]{2, 4, 1, 6, 5, 9, 7};
        expected = 3;
    }

    @Test
    public void test_2() {
        ints = new int[]{4, 3, 2, 6, 1};
        expected = 1;
    }

    @Test
    public void test_3() {
        ints = new int[]{2, 1, 6, 4, 3, 7};
        expected = 3;
    }

    @Test
    public void test_4() {
        // todo - max bounds
    }

}
