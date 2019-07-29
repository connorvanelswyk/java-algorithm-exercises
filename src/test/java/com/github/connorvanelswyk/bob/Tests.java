package com.github.connorvanelswyk.bob;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;


@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {

    final Solution solution = new Solution();

    int[] x;
    int[] y;
    int expected;

    @After
    public void after() {

        Point2D[] points = IntStream
                .range(0, x.length)
                .boxed()
                .map(i -> {
                    Point2D point2D = new Point2D();
                    point2D.x = x[i];
                    point2D.y = y[i];
                    return point2D;
                })
                .toArray(Point2D[]::new);

        int actual = solution.solution(points);
        log.debug("  points=[{}]", x.length);
        log.debug("  actual=[{}]", actual);
        log.debug("expected=[{}]", expected);
        assertEquals(expected, actual);
    }

    @Test
    public void test_1() {
        x = new int[]{-1, 1, 2, -3, 2};
        y = new int[]{-2, 2, 4, 2, -2};
        expected = 4; // (1,2) & (2,4) both have a slope of 2
    }

    @Test
    public void test_2() {
        long size = new Random().nextInt(100_000);
        int origin = -999_999_999;
        int bound = origin * -1;
        x = new Random().ints(size, origin, bound).toArray();
        y = new Random().ints(size, origin, bound).toArray();
        Set<Float> q1 = new HashSet<>();
        Set<Float> q2 = new HashSet<>();
        Set<Float> q3 = new HashSet<>();
        Set<Float> q4 = new HashSet<>();
        for (int i = 0; i < size; i++) {
            float a = x[i];
            float b = y[i];
            float m = b / a;
            if (a > 0 && b > 0) {
                q1.add(m);
            } else if (a > 0 && b < 0) {
                q2.add(m);
            } else if (a < 0 && b < 0) {
                q3.add(m);
            } else {
                q4.add(m);
            }
        }
        expected = q1.size() + q2.size() + q3.size() + q4.size();
    }

    @Test
    public void test_3() {
        long size = new Random().nextInt(100_000);
        int origin = -99;
        int bound = origin * -1;
        x = new Random().ints(size, origin, bound).toArray();
        y = new Random().ints(size, origin, bound).toArray();
        Set<Float> q1 = new HashSet<>();
        Set<Float> q2 = new HashSet<>();
        Set<Float> q3 = new HashSet<>();
        Set<Float> q4 = new HashSet<>();
        for (int i = 0; i < size; i++) {
            float a = x[i];
            float b = y[i];
            float m = b / a;
            if (a > 0 && b > 0) {
                q1.add(m);
            } else if (a > 0 && b < 0) {
                q2.add(m);
            } else if (a < 0 && b < 0) {
                q3.add(m);
            } else {
                q4.add(m);
            }
        }
        expected = q1.size() + q2.size() + q3.size() + q4.size();
    }

}
