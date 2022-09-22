package com.gdp.Arrays_and_Strings;

public class Arrays_and_Strings {

    public static void main(String[] args) {
        String phrase = "saras";
        boolean result = isPermutationOfPalindrome(phrase);
        System.out.println("isPermutationOfPalindrome" + "('" + phrase + "') = " + result);
    }

    /**
     * check if permutation of a certain string can be a palindrome.
     * @param phrase a string argument
     * @return true if odd character in the string is 1 or less. <br>
     * 'gigi' → 'giig', 'iggi'. <br>
     * while 'gijin' is not possible because there's more than 1 odd character ('g' and 'j').
     */
    public static boolean isPermutationOfPalindrome(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    private static final int numeric_a = Character.getNumericValue('a');
    private static final int numeric_z = Character.getNumericValue('z');
    public static int getCharNumber(Character c) {
        int numeric_c = Character.getNumericValue(c);
        return (numeric_c >= numeric_a && numeric_c <= numeric_z) ? (numeric_c - numeric_a) : -1;
    }
}