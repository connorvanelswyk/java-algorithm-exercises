package com.github.connorvanelswyk.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class provides an algorithm to recover bit matrices with 2 rows, n columns, and the sum index values per row.
 */
public class Solution {

    /**
     * This function constructs a 2-dimensional matrix by iterating through an array of integers and inserting binary
     * values in each row with respect to the predefined tuple sums.
     * values
     * @param upper - an {@code Integer} representing the sum of values in row 1
     * @param lower - an {@code Integer} representing the sum of values in row 2
     * @param ints - an array where object is an {@code Integer} in range [0,2]
     * @return a {@code String} value with a recovered matrix represented with comma delimited rows char values
     * or {@literal IMPOSSIBLE}, if no solution exists.
     */
    public String solution(int upper, int lower, int[] ints) {
        if (Arrays.stream(ints).reduce(0, Integer::sum) != upper + lower) {
            return "IMPOSSIBLE";
        }
        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();
        int row1Sum = 0;
        int row2Sum = 0;
        for (int i : ints) {
            if (i == 2) {
                row1.add(1);
                row2.add(1);
                row1Sum++;
                row2Sum++;
            } else if (i == 0) {
                row1.add(0);
                row2.add(0);
            } else if (upper - row1Sum > lower - row2Sum) {
                row1.add(1);
                row2.add(0);
                row1Sum++;
            } else {
                row1.add(0);
                row2.add(1);
                row2Sum++;
            }
        }
        return String.join(",",
                row1.stream().map(String::valueOf).collect(Collectors.joining("")),
                row2.stream().map(String::valueOf).collect(Collectors.joining("")));
    }

}