/**
 * Author: Mustafa Jamal
 * 
 * Asked by: Andela
 * 
 * this problem checks if the n is palindrom else add the reveresed of n to n and check again then return the number of those iterations.
 * 
 * Example: if n = 78, it's not a palin then add 87 (the reveresed to it) = 165 still not palin in the 4th iteration n will be 4884 which is palin, so return 4.
 */

class Palin {

    public static void main(String[] args) {
        System.out.println(counts(78));
    }

    static boolean isPalin(int n) {
        int reversedInteger = 0, remainder, originalInteger;
        originalInteger = n;

        // reversed integer is stored in variable 
        while(n != 0) {
            remainder = n % 10;
            reversedInteger = reversedInteger * 10 + remainder;
            n  /= 10;
        }
        return originalInteger == reversedInteger;
    }

    static int reverseInt(int n) {
        int reversedInteger = 0, remainder;
        while(n != 0) {
            remainder = n % 10;
            reversedInteger = reversedInteger * 10 + remainder;
            n  /= 10;
        }
        return reversedInteger; 
    }

    static int counts(int n) {
        int count = 0;
        while (!isPalin(n)) {
            System.out.println(n);
            n = n + reverseInt(n);
            count++;
        }
        System.out.println(n + "\n");
        return count;
    }
}