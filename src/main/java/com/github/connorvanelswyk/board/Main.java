package com.github.connorvanelswyk.board;

import com.github.connorvanelswyk.Randomizer;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
    }

    private static void test1() {
        int U = 3;
        int L = 2;
        int[] C = new int[]{2, 1, 1, 0, 1};
        String s = new Solution().solution(U, L, C);
        System.out.println(s);
    }

    private static void test2() {
        int U = 2;
        int L = 3;
        int[] C = new int[]{0, 0, 1, 1, 2};
        String s = new Solution().solution(U, L, C);
        System.out.println(s);
    }

    private static void test3() {
        int U = Randomizer.generate(0, 100000);
        int L = Randomizer.generate(0, 100000);
        int[] C = IntStream.rangeClosed(1, 100000)
                .boxed()
                .mapToInt(i -> Randomizer.generate(0, 2))
                .toArray();
        int ulSum = U + L;
        int cSum = Arrays.stream(C).sum();
        System.out.println(cSum);
        System.out.println(ulSum);
        String s = new Solution().solution(U, L, C);
        System.out.println(s);
    }
}
