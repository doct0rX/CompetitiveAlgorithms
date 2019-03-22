/**
 * Author: Mustafa Jamal
 *
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * This problem was asked by LinkedIn.
 *
 * Given a string, return whether it represents a number. Here are the different kinds of numbers:
 *
 * "10", a positive integer
 * "-10", a negative integer
 * "10.1", a positive real number
 * "-10.1", a negative real number
 * "1e5", a number in scientific notation
 *
 *  And here are examples of non-numbers:
 * 
 * "a"
 * "x 1"
 * "a -2"
 * "-"
 */

import org.apache.commons.lang3.*;

class IsNumber {
    
    // static NumberUtils numberUtils = new NumberUtils();
    public static void main(String[] args) {
        System.out.println(isNumber("11"));
    }

    static boolean isNumber(String num) {
        return NumbersUtils.isNumber(num);
    }
}