package com.gdp.Recursion_and_Dynamic_Programming;

public class Recursion {
    public static void main(String[] args) {
        int numOfWays = countWays(4);
        System.out.println(numOfWays);
    }

    static int countWays(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        return countWays((n - 1)) + countWays((n - 2)) + countWays((n - 3));
    }
}
