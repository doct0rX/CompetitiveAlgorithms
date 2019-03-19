/**
 * Author: Mustafa Jamal
 * 
 * from DailyCoding problem
 * 
 * This problem was asked by Google.
 * Given a string which we can delete at most k, return whether you can make a palindrome.
 * For example, given 'waterrfetawx' and a k of 2, you could delete f and x to get 'waterretaw'.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.StringBuilder;

public class IsPalindrome {

    public static void main(String[] args) {
        // Testing
        // Those test cases added by me while solving the problem
        System.out.println(isPalin("waterrfetawx", 2));   // true
        System.out.println(isPalin("waterretaw", 0));     // true
        System.out.println(isPalin("waterretzaw", 1));    // true
        System.out.println(isPalin("zwatezrrfetawx", 4)); // true // TODO: Still not done in TODO 1
        System.out.println(isPalin("waterrfetawx", 1));   // false
        System.out.println(isPalin("waterrfetawx", 3));   // false
        System.out.println(isPalin("waterrfetawx", 0));   // false
        System.out.println(isPalin("zwatezrrfetawx", 2)); // false
    }

    static String isPalin(String word, int k) {
        String s = word;
        StringBuilder reverseStringBuilder;
        String reverse = new String();
        char[] originalStringToCharArray = word.toCharArray();
        List<Character> palinStringToCharArray = new ArrayList<Character>();
        List<Character> removedChars = new ArrayList<Character>();
        int i = 0;

        Map<Character, Integer> map = new HashMap<>();
        for(char c : originalStringToCharArray)
        {
            if(map.containsKey(c)) {
                int counter = map.get(c);
                map.put(c, ++counter);
            } else {
                map.put(c, 1);
            }
        }

        // add duplicated chars to palinStringToCharArray 
        for(char c : map.keySet()) {
            if(map.get(c) > 1) {
                palinStringToCharArray.add(c);
            } else {
                removedChars.add(c);
                i++;
            }
        }

        for (char ch : removedChars) {
            s = s.replace(String.valueOf(ch), "");
        }

        // TODO 1: this needs to check if k still has chars to remove and then remove non palindrom chars from the String.
        while (i < k) {
            
            i++;
        }
        
        reverseStringBuilder = new StringBuilder(s);
        reverse = reverseStringBuilder.reverse().toString();

        if (palinStringToCharArray.size() * 2 + k == originalStringToCharArray.length && s.equalsIgnoreCase(reverse)) {
            return s;
        } else {
            return "Can't make a palindrom\n" + palinStringToCharArray.toString();
        }
    }
}
