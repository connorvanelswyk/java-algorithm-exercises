package com.github.connorvanelswyk.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public String solution(int U, int L, int[] C) {
        if (Arrays.stream(C).reduce(0, Integer::sum) != U + L) {
            return "IMPOSSIBLE";
        }
        List<Integer> u = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        for (Integer c : C) {
            if (c == 2) {
                u.add(1);
                l.add(1);
            } else if (c == 1) {
                int d = Integer.compareUnsigned(sum(u), sum(l));
                if (d == 0 || d < 0) {
                    u.add(1);
                    l.add(0);
                } else {
                    u.add(0);
                    l.add(1);
                }
            } else {
                u.add(0);
                l.add(0);
            }
        }
        String uStr = u.stream().map(String::valueOf).collect(Collectors.joining(""));
        String lStr = l.stream().map(String::valueOf).collect(Collectors.joining(""));
        return String.join(",", uStr, lStr);
    }

    private int sum(List<Integer> integers) {
        return integers.stream().reduce(0, Integer::sum);
    }

}