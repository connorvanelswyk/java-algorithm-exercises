package com.github.connorvanelswyk.matrix;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {

    final Solution solution = new Solution();

    int[] ints;
    int upper;
    int lower;
    String expected;

    @After
    public void after() {
        String actual = solution.solution(upper, lower, ints);
        log.debug("upper=[{}]", upper);
        log.debug("lower=[{}]", lower);
        log.debug("ints={}", Arrays.toString(ints));
        log.debug("assertEquals(\n[{}],\n[{}]\n)", expected, actual);
        String u = actual.substring(0, actual.indexOf(","));
        String l = actual.substring(actual.indexOf(",") + 1);
        IntStream.of(ints).forEach(i -> assertEquals(ints[i], (u.charAt(i) - '0') + (l.charAt(i) - '0')));
    }

    @Test
    public void test_1() {
        ints = new int[]{2, 1, 1, 0, 1};
        upper = 3;
        lower = 2;
        expected = "11001,10100";
    }

    @Test
    public void test_2() {
        ints = new int[]{0, 0, 1, 1, 2};
        upper = 2;
        lower = 3;
        expected = "IMPOSSIBLE";
    }

    @Test
    public void test_3() {
        ints = new int[]{2, 0, 2, 0};
        upper = 2;
        lower = 2;
        expected = "1010,1010";
    }

    @Test
    public void test_4() {
        int size = 100_000;
        int origin = 0;
        int bound = 2;
        List<Integer> row1 = new Random().ints(size / 2, origin, bound).boxed().collect(Collectors.toList());
        List<Integer> row2 = new Random().ints(size / 2, origin, bound).boxed().collect(Collectors.toList());
        ints = IntStream.range(0, size / 2).boxed().mapToInt(i -> row1.get(i) + row2.get(i)).toArray();
        upper = row1.stream().mapToInt(Integer::valueOf).sum();
        lower = row2.stream().mapToInt(Integer::valueOf).sum();
        expected = String.join(",",
                row1.stream().map(String::valueOf).collect(Collectors.joining("")),
                row2.stream().map(String::valueOf).collect(Collectors.joining("")));
    }

}
