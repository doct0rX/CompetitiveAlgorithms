package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1, 2, 3}));
//        System.out.println(solution(new int[]{0, 1, 1, 2, 3, 3}, 3)); // false
//        System.out.println(solution(new int[]{1, 1, 2, 3, 3}, 3)); // true
//        System.out.println(solution(new int[]{1, 1, 3}, 2)); // false

//        System.out.println(solution(new int[]{1, 2, 5, 9, 9}, 5)); //2
//        System.out.println(solution(new int[]{1, 2, 5, 9, 9}, 9)); //3 or 4
//        System.out.println(solution(new int[]{1, 2, 5, 9, 9}, 2)); //1
//        System.out.println(solution(new int[]{1, 2, 5, 9, 9}, 1)); //0
    }


//    static int solution(int[] A, int X) {
//        int N = A.length;
//        if (N == 0) {
//            return -1;
//        }
//
//        int l = 0;
//        int r = N - 1; // length from 0
//        while (l < r) { // len < array len
//            int m = (l + r) / 2 + 1;    // mid value
//            if (A[m] > X) {     // mid value > X
//                r = m - 1;      // range = mid - 1
//            } else {
//                l = m;          // mid value <=  X then; l = mid
//            }
//        }
//        if (A[l] == X) {
//            return l;
//        }
//        return -1;
//    }

//    public static boolean solution(int[] A, int K) {
//        int n = A.length;
//        boolean res = false;
//        for (int i = 0; i < n - 1; i++) {
//            if (A[i] + 1 < A[i + 1])
//                return false;
//        }
//        if (A[0] != 1)
//            return false;
//        else
//            return true;
//    }

    static String solution(String S, String T) {
        if (sameChars(S, T)) {

            String[] arr = S.split("");
            String[] brr = T.split("");
            StringBuilder result = new StringBuilder();

            //Iterate over both arrays
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < brr.length; j++) {
                    //Find first matching character
                    if (arr[i].equals( brr[j])) {
                        //While there are more characters in both arrays and the characters keep matching, append them
                        // to the result
                        while (arr[i].equals(brr[j]) && i < arr.length && j < brr.length) {
                            result.append(arr[i]);
                            i++;
                            j++;
                        }
                        return result.toString();
                    }
                }
            }
            return result.toString();
//            String tReverse = new StringBuilder(T).reverse().toString();
//            int sl = S.length();
//            int tl = T.length();
//            int result = 0;
//            int end = 0;
//            int len[][] = new int[2][sl];
//            int currRow = 0;
//
//            for (int i = 0; i < sl; i++) {
//                for (int j = 0; j <= tl ; j++) {
//                    if (i == 0 || j == 0) {
//                        len[currRow][j] = 0;
//                    } else if (S.charAt(i - 1) == tReverse.charAt(j - 1)) {
//                        len[currRow][j] = len[1 - currRow][j - 1] + 1;
//                        if (len[currRow][j] > result) {
//                            result = len[currRow][j];
//                            end = i - 1;
//                        }
//                    } else {
//                        len[currRow][j] = 0;
//                    }
//                }
//                currRow = 1 - currRow;
//            }
//
//            if (result == 0) {
//                return "";
//            }
//            return S.substring(end - result + 1, result)
        } else {
            return "";
        }
    }

    static boolean sameChars(String S, String T) {
        char[] first = S.toCharArray();
        char[] second = T.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }

//    public static int solution(String S) {
//
//
//        // Put all distinct substring in a HashSet
//        ArrayList<String> result = new ArrayList<String>();
//        int chrCounter = 0;
//        String temp = "";
//
//        for (int i = 0; i < S.length(); i++) {
//            for (int j = i+1; j <= S.length(); j++) {
//                result.add(S.substring(i,j));
//            }
//        }
//
//        for (String s: result) {
//            for (char c: s.toCharArray()) {
//                String newS = s.replaceFirst(String.valueOf(c), "");
//                if (!newS.contains(String.valueOf(c))) {
//                    chrCounter++;
//                }
//            }
//        }
//
//        return chrCounter;
//    }
}
