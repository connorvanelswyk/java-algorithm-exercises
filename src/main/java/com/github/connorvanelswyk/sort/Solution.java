package com.github.connorvanelswyk.sort;

public class Solution {

    public int Solution(int[] A) {
        int r = 1;
        int min = 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (i < 2) {
                min = Math.min(min, A[i]);
                max = Math.max(max, A[i]);
            } else if (A[i] > max) {
                r++;
                min = max;
                max = A[i];
            } else if (A[i] < min) {
                return 1;
            }
        }
        return r;
    }

}
