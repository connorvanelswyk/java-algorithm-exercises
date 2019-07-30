package com.github.connorvanelswyk.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public String solution(int upper, int lower, int[] ints) {
        if (Arrays.stream(ints).reduce(0, Integer::sum) != upper + lower) {
            return "IMPOSSIBLE";
        }
        List<Integer> u = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        IntStream.of(ints).forEach(i -> {
            if (i == 2) {
                u.add(1);
                l.add(1);
            } else if (i == 0) {
                u.add(0);
                l.add(0);
            } else {
                u.add(0);
                l.add(1);
            }
        });
        String uStr = u.stream().map(String::valueOf).collect(Collectors.joining(""));
        String lStr = l.stream().map(String::valueOf).collect(Collectors.joining(""));
        return String.join(",", uStr, lStr);
    }

}