package com.gdp.Bit_Manipulation;

public class Bit_Manipulation1 {
    public static void main(String[] args) {
        // try changing below value
        String b_firstOperand = "1100";
        String b_secondOperand = "1010";
        int shiftRight = 2;
        int shiftLeft = 1;

        manipulateBit(b_firstOperand, b_secondOperand, shiftRight, shiftLeft);
    }

    static int maxOperandLength;

    public static void manipulateBit(String firstOperand, String secondOperand, int shiftRight, int shiftLeft) {
        int i_firstOperand = Integer.parseInt(firstOperand, 2);
        int i_secondOperand = Integer.parseInt(secondOperand, 2);

        // using max in case firstOperand and secondOperand have different length
        maxOperandLength = Math.max(firstOperand.length(), secondOperand.length());
        String hr = new String(new char[maxOperandLength]).replace("\0", "_");

        String[] operators = new String[]{"&", "|", "~", "^", ">>", "<<"};
        for (String operator : operators) {
            System.out.println(firstOperand + " \t " + Integer.parseInt(firstOperand, 2));
            System.out.println(secondOperand + " \t " + Integer.parseInt(secondOperand, 2));

            System.out.println(hr + " " + operator);

            // "&" AND
            if (operator.equals("&")) {
                manipulate_and(i_firstOperand, i_secondOperand);
            }

            // "|" OR
            else if (operator.equals("|")) {
                manipulate_or(i_firstOperand, i_secondOperand);
            }

            // "~" NOT
            else if (operator.equals("~")) {
                manipulate_not(i_firstOperand, i_secondOperand);
            }

            // "^" XOR
            else if (operator.equals("^")) {
                manipulate_xor(i_firstOperand, i_secondOperand);
            }

            // ">>" SHIFT RIGHT
            else if (operator.equals(">>")) {
                manipulate_sr(i_firstOperand, i_secondOperand, shiftRight);
            }

            // "<<" SHIFT LEFT
            else {
                manipulate_sl(i_firstOperand, i_secondOperand, shiftLeft);
            }

            System.out.println();
        }
    }


    public static void manipulate_and(int firstOperand, int secondOperand) {
        int result = firstOperand & secondOperand;
        System.out.println(Integer.toBinaryString(result) + " \t " + result);
    }

    public static void manipulate_or(int firstOperand, int secondOperand) {
        int result = firstOperand | secondOperand;
        System.out.println(Integer.toBinaryString(result) + " \t " + result);
    }

    private static void manipulate_not(int firstOperand, int secondOperand) {
        String b_firstOperand = Integer.toBinaryString(firstOperand);
        String b_secondOperand = Integer.toBinaryString(secondOperand);

        int result = ~firstOperand;
        String s_result = Integer.toBinaryString(result);
        s_result = s_result.substring(s_result.length() - b_firstOperand.length());
        System.out.println(s_result + " \t " + result);
        result = ~secondOperand;
        s_result = Integer.toBinaryString(result);
        s_result = s_result.substring(s_result.length() - b_secondOperand.length());
        System.out.println(s_result + " \t " + result);
    }

    private static void manipulate_xor(int firstOperand, int secondOperand) {
        int result = firstOperand ^ secondOperand;
        String s_result = String.format("%1$" + maxOperandLength + "s", Integer.toBinaryString(result)).replace(' ', '0');
        System.out.println(s_result + " \t " + result);
    }

    private static void manipulate_sr(int firstOperand, int secondOperand, int shiftRight) {
        int result = firstOperand >> shiftRight;
        String s_result = Integer.toBinaryString(result);
        s_result = trimAndPad(s_result);
        System.out.println(s_result + " \t " + result + ", shifted right " + shiftRight);

        result = secondOperand >> shiftRight;
        s_result = Integer.toBinaryString(result);
        s_result = trimAndPad(s_result);
        System.out.println(s_result + " \t " + result + ", shifted right " + shiftRight);
    }

    private static void manipulate_sl(int firstOperand, int secondOperand, int shiftLeft) {
        int result = firstOperand << shiftLeft;
        String s_result = Integer.toBinaryString(result);
        s_result = trimAndPad(s_result);
        System.out.println(s_result + " \t " + result + ", shifted left " + shiftLeft);

        result = secondOperand << shiftLeft;
        s_result = Integer.toBinaryString(result);
        s_result = trimAndPad(s_result);
        System.out.println(s_result + " \t " + result + ", shifted left " + shiftLeft);
    }

    private static String trimAndPad(String binary) {
//        if (binary.length() > maxOperandLength) {
//            binary = binary.substring(binary.length() - maxOperandLength);
//        }
        return String.format("%1$" + maxOperandLength + "s", binary).replace(' ', '0');
    }


}