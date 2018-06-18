import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class SolutionMath {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.close();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        for (int i = 0; i <= N; i++) {
            // This Checks the low bit -> it will always be an odd number
            // https://stackoverflow.com/questions/7342237/check-whether-number-is-even-or-odd
            if ( (i & 1) != 0 ){
                System.out.println(i);
            }
            System.out.print("->");
            System.out.println(i & 1);
        }
    }
}