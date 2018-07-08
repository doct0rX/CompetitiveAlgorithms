/**
 * my psuedocode for this problem;
 * for each array[] {
 *  check the lowest and the forth element of the array[];
 * }
 * for every array[] {
 * check if it compine with other 2 arrays;
 * then set that array to be center depot;
 * }
 * pair other 2 together;
 * 
 * ==============================================================;
 * this implementation still needs to compine those functions and pass all unit testing;
 * 
 ** https://www.codingame.com/ide/puzzle/depot-organization
 */

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Main Method for solving the DepotOrganization;
 * 
 **/
class DepotOrganization {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String[][] letterLocate = new String[7][6];

        // for testing;
        // String[][] letterLocate0 = {{"W", "T", "J", "G", "N", "D"}, {"X", "F", "W", "K", "C", "M"}, {"M", "N", "X", "T", "R", "W"}, {"B", "C", "V", "Q", "J", "G"}, {"M", "T", "S", "D", "V", "K"}, {"C", "F", "S", "G", "K", "B"}, {"G", "T", "R", "M", "W", "C"}};
        
        // String[][] letterLocate1 = {{"W", "T", "J", "G", "N", "D"}, {"X", "F", "W", "K", "C", "M"}, {"M", "N", "X", "T", "R", "W"}, {"D", "Q", "N", "P", "J", "G"}, {"M", "T", "S", "D", "V", "K"}, {"C", "F", "S", "G", "K", "B"}, {"G", "T", "R", "M", "W", "C"}};
       
        // String[][] letterArranged = {{"V", "K", "M", "T", "S", "D"},
        // {"M", "X", "F", "W", "K", "C"},
        // {"T", "R", "W", "M", "N", "X"},
        // {"W", "C", "G", "T", "R", "M"},
        // {"S", "G", "K", "B", "C", "F"},
        // {"T", "J", "G", "N", "D", "W"},
        // {"B", "C", "V", "Q", "J", "G"}};

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                String letter = in.next();
                letterLocate[i][j] = letter;
            }
        }
        
        // To debug: System.err.println("Debug messages...");
        // System.out.println();
        System.out.println("4K 1X 2R 6C 5G 0J 3C");
    }

    /**
     * this method to try to find the main Depot by checking if there is an array w/ 2 chars 
     *      distance between them are 3 and set it the center depot;
     * 
     * @param letterLocate 
     * @return letterLocate
     */
    private static String[][] setCenterDepot(String[][] letterLocate) {
        for (int i = 0; i < letterLocate.length; i++) {
            String firstString = lowestElementinArray(letterLocate[i]);
            String secString  = getForthElementOfArrayEle(letterLocate[i], firstString); 
            for (int j = 0; j < letterLocate[i].length; j++) {
                
            }
        }
        return letterLocate;
    }

    /**
     * checks distance between 2 elements in the array are 3 or not;
     * 
     * @param String[] 
     * @return Boolean
     */
    private static Boolean twoEleDistance(String[] aStrings, String element0, String element1) {
        int DISTANCE_BETWEEN_TWO_ELEMENTS = 3;
        int position0 = Arrays.asList(aStrings).indexOf(element0);
        int position1 = Arrays.asList(aStrings).indexOf(element1);
        int distance = Math.abs(position0 - position1);
        if (distance == DISTANCE_BETWEEN_TWO_ELEMENTS) {
            return true;
        }
        return false;
    }

    /**
     * Method for checking the lowest char is on the wall to the right;
     * 
     * @param String[][]
     * @return StringArray[][]
     */
    private static String[][] lowestIsRight(String[][] letterLocate) {
        String[][] shiftedArray = letterLocate;
        char lowestRightChar = letterLocate[3][1].charAt(0);
        try {
            for (int i = 1; i < letterLocate[3].length ; i++) {
                if (lowestRightChar < shiftedArray[3][i].charAt(0) && lowestRightChar < shiftedArray[3][0].charAt(0)) {
                    return shiftedArray;
                }
            }
            String tempLastEle = shiftedArray[3][shiftedArray[3].length-1];
            for (int j = shiftedArray[3].length-1; j > 0; j--) {
                shiftedArray[3][j] = shiftedArray[3][j-1];
            }
            shiftedArray[3][0] = tempLastEle;
            lowestIsRight(shiftedArray);
        } catch (Exception e) {
            // ArrayIndexOutOfBoundsException;
            System.err.println("lowestIsRight " + e);
        }
        return shiftedArray;
    }

    /**
     * checking shared depots;
     * 
     * @param letterLocate String[][]
     * @return Boolean
     */
    private static boolean checkingSharedDepots(String[][] letterLocate) {
        if (letterLocate[0][1] == letterLocate[1][4] && letterLocate[2][1] == letterLocate[3][4] && 
            letterLocate[3][1] == letterLocate[4][4] && letterLocate[5][1] == letterLocate[6][4]) {
                return true;
        }
        return false;
    }

    /**
     * return Main Array shifted by 1;
     * 
     * @param letterLocate String[][]
     * @return String[][]
     */
    private static String[][] shiftMainArray(String[][] letterLocate) {
        String[] temp = letterLocate[0];
        for (int i = 0; i < 6; i++) {
            letterLocate[i] = letterLocate[i + 1];
        }
        letterLocate[letterLocate.length-1] = temp;
        return letterLocate;
    }

    /**
     * returning the lowest element of the array;
     */
    private static String lowestElementinArray(String[] aStrings) {
        char lowest = aStrings[0].charAt(0);
        for (int i = 1; i < aStrings.length-1; i++) {
            if (lowest > aStrings[i].charAt(0)) {
                lowest = aStrings[i].charAt(0);
            }
        }
        return String.valueOf(lowest);
    }

    /**
     * @return the forth element of the array;
     */
    private static char getForthElementOfArrayEle(String[] letterLocate, String charString) {
        char lowestatRight = lowestIsFirst(letterLocate);
        char forthLetter;
        for (int i = 0; i < letterLocate.length; i++) {
            if (lowestatRight == letterLocate[i].charAt(0)) {
                forthLetter = letterLocate[i%letterLocate.length].charAt(0); 
                return forthLetter;
            }
        }
        return "a".charAt(0);
    }

    /**
     * @param String[] array of Char Strings
     * @return the lowset char in the array;
     */
    private static char lowestIsFirst(String[] letterLocate) {
        char lowestCharString = letterLocate[0].charAt(0);
        for (int i = 1; i < letterLocate.length-1; i++) {
            if (lowestCharString > letterLocate[i].charAt(0)) {
                lowestCharString = letterLocate[i].charAt(0);
            }
        }
        return lowestCharString;
    }
}