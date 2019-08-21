/**
 * Author: Mustafa Jamal
 * 
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * Example:
 * Input: "Hello World"
 * Output: 5
 */

class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("Hello "));
        System.out.println(lengthOfLastWord("Hello"));
        System.out.println(lengthOfLastWord("Hello  "));
        System.out.println(lengthOfLastWord(" Hello"));
        System.out.println(lengthOfLastWord("h"));
        System.out.println(lengthOfLastWord(""));
        System.out.println(lengthOfLastWord(" "));
    }

    static public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        for (int i = arr.length - 1; i >= 0; i--)
            if (arr[i].length() != 0) 
                return arr[i].length();
        return 0;
    }
}