package com.github.connorvanelswyk.sort;

public class Solution {

    public int solution(int[] ints) {
        int r = 1;
        int min = 0;
        int max = 0;
        for (int i = 0; i < ints.length; i++) {
            if (i < 2) {
                min = Math.min(min, ints[i]);
                max = Math.max(max, ints[i]);
            } else if (ints[i] > max) {
                r++;
                min = max;
                max = ints[i];
            } else if (ints[i] < min) {
                return 1;
            }
        }
        return r;
    }

}
