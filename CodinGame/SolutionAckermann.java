import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class SolutionAckermann {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        in.close();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        ackermann(m, n);

        try {
            System.out.println(ackermann(m, n));  
        } catch (Exception e) {
            System.out.println(-1);
        }
        
    }

    public static int ackermann(int n1, int m1) {
        if (m1 == 0) {
            return(n1 + 1);
        } else if (n1 == 0) {
            return ackermann(m1 - 1, 1);
        } else {
            return ackermann(m1 - 1, ackermann(m1, n1 - 1));
        }
    }
}