package com.github.connorvanelswyk.slope;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This class provides an algorithm to calculate geometric ray equations in 2-dimensional Euclidean space.
 */
public class Solution {

    /**
     * This method is the primary function for this class, using a streams, sorting, mapping, grouping, and summing.
     * The order of operations are as follows:
     * 1. order points from near to far in respect to the origin
     * 2. group points into 4 collections, representing their native quadrant
     * 3. map each collection to an {@code Integer} by grouping points with identical slopes
     * 4. sum and return the amount of distinct slopes from step 3
     * @param points - an array of {@link Point2D} objects representing points/coordinates on a graph
     * @return the least amount rays required to pass through each of the given points
     */
    public int solution(Point2D[] points) {
        return Arrays.stream(points)
                .sorted(sortByValue())
                .collect(Collectors.groupingBy(quadrant()))
                .values()
                .stream()
                .map(hitsPerQuadrant())
                .mapToInt(Integer::intValue)
                .sum();
    }

    private Comparator<Point2D> sortByValue() {
        return (p1, p2) -> p1.x < p2.x ? -1 : p1.x > p2.x ? 1 : Integer.compare(p1.y, p2.y);
    }

    private Function<List<Point2D>, Integer> hitsPerQuadrant() {
        return ps -> ps.stream().collect(Collectors.groupingBy(p -> (float) p.y / p.x)).size();
    }

    private Function<Point2D, Integer> quadrant() {
        return p -> p.x > 0 && p.y > 0 ? 1 : p.x > 0 && p.y < 0 ? 2 : p.x < 0 && p.y < 0 ? 3 : 4;
    }

}
