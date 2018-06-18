import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        int[] arr;

       for (int i = 0; i <= s.length(); i++) {
            char character = s.charAt(i); // This gives the character 'a'
            System.out.println(character);
            int ascii = (int) character; // ascii is now 97. 
            System.out.println(ascii);
            arr = new int[i];
        }     

        System.out.println("average");
    }
}