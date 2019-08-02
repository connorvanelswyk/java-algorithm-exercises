package com.github.connorvanelswyk.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

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