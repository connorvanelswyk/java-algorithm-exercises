package com.github.connorvanelswyk.sort;

public class Main {

    private static Solution solution = new Solution();

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() {
        int[] A = new int[]{2, 4, 1, 6, 5, 9, 7};
        System.out.println(solution.Solution(A));
    }

    public static void test2() {
        int[] A = new int[]{4, 3, 2, 6, 1};
        System.out.println(solution.Solution(A));
    }

    public static void test3() {
        int[] A = new int[]{2, 1, 6, 4, 3, 7};
        System.out.println(solution.Solution(A));
    }

    public static void test4() {

    }

}
