package com.gdp.Recursion_and_Dynamic_Programming.memoization;

import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
        // change n to experiment
        int n = 4;
        int numOfWays = countWays(n);
        System.out.println(numOfWays);
    }

    static int countWays(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }

    private static int countWays(int n, int[] memo) {
        if (n < 0) return 0;
        if (n < 1) return 1;
        if (memo[n] > -1) return memo[n];
        memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
        return memo[n];
    }
}
