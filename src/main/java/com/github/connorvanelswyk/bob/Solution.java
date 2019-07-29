package com.github.connorvanelswyk.bob;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public int solution(Point2D[] A) {
        return Arrays.stream(A)
                .sorted(sortByValue())
                .collect(Collectors.groupingBy(quadrant()))
                .values()
                .stream()
                .map(hitsPerQuadrant())
                .mapToInt(Integer::intValue)
                .sum();
    }

    private Comparator<Point2D> sortByValue() {
        return (p1, p2) -> {
            if (p1.x < p2.x) {
                return -1;
            } else if (p1.x > p2.x) {
                return 1;
            } else {
                return Integer.compare(p1.y, p2.y);
            }
        };
    }

    private Function<List<Point2D>, Integer> hitsPerQuadrant() {
        return ps -> ps.stream().collect(Collectors.groupingBy(p -> (float) p.y / p.x)).size();
    }

    private Function<Point2D, Integer> quadrant() {
        return p -> {
            if (p.x > 0 && p.y > 0) {
                return 1;
            } else if (p.x > 0 && p.y < 0) {
                return 2;
            } else if (p.x < 0 && p.y < 0) {
                return 3;
            } else {
                return 4;
            }
        };
    }

}
