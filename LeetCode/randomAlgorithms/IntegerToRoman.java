/**
 * Author: Mustafa Jamal
 * 
 * Leet Code problem; 12: Integer to Roman
 * https://leetcode.com/problems/integer-to-roman/
 * 
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * 
 * Runtime: 4 ms, faster than 69.29% of Java online submissions for Integer to Roman.
 * Memory Usage: 36.3 MB, less than 99.98% of Java online submissions for Integer to Roman.
 */


class IntegerToRoman {

    static int input0 = 3;
    static String output0 = "III";
    static int input1 = 4;
    static String output1 = "IV";
    static int input2 = 9;
    static String output2 = "IX";
    static int input3 = 58;
    static String output3 = "LVIII";
    static int input4 = 1994;
    static String output4 = "MCMXCIV";

    public static void main(String[] args) {
        System.out.println(intToRoman(3999).equals("MMMCMXCIX"));
        System.out.println(intToRoman(input0) + " : " + output0 + " - " + intToRoman(input0).equals(output0));
        System.out.println(intToRoman(input1) + " : " + output1 + " - " + intToRoman(input1).equals(output1));
        System.out.println(intToRoman(input2) + " : " + output2 + " - " + intToRoman(input2).equals(output2));
        System.out.println(intToRoman(input3) + " : " + output3 + " - " + intToRoman(input3).equals(output3));
        System.out.println(intToRoman(input4) + " : " + output4 + " - " + intToRoman(input4).equals(output4));
    }

    /**
     * This function retruns the roman letter based on the box of the digit; and as it's finite value it can be predefined;
     */
    static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num / 100) % 10] + X[(num / 10) % 10] + I[num % 10];
    }
}