package com.gdp.Bit_Manipulation;// Debugger: Explain what the following code does:
// ((n & (n - 1)) == 0)

public class Bit_Manipulation2 {
    public static void main(String[] args) {

        // variable declaration
        boolean result;
        String b1, b2;
        int maxLength;

        // change below value to experiment
        int explorationNum = 100;
        for (int i = 1; i < explorationNum; i++) {
            result = ((i & (i - 1)) == 0);
            b1 = Integer.toBinaryString(i);
            b2 = Integer.toBinaryString(i - 1);
            maxLength = Math.max(b1.length(), b2.length());

            // will return true if i is POW of 2.
            System.out.println(padLeftZ(b1, maxLength, '0') + "\t" + i);
            System.out.println(padLeftZ(b2, maxLength, '0') + "\t" + (i - 1));
            System.out.println("((" + i + " & " + (i - 1) + ") == 0)?");
            System.out.println(result + "\n");
        }
    }

    public static String padLeftZ(String s, int n, char newChar) {
        return String.format("%" + n + "s", s).replace(' ', newChar);
    }
}