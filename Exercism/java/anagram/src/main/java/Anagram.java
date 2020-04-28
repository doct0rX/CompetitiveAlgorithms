/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Anagram {

    String mainStr;
    char[] word;

    Anagram(String str) {
        mainStr = str.toLowerCase();
        word = sortCharArray(str);
    }

    List<String> match(List<String> stringArrayList) {
        ArrayList<String> anagrams = new ArrayList<String>();
        for (int i = 0; i < stringArrayList.size(); i++) {
            char[] cur = sortCharArray(stringArrayList.get(i));
            if (Arrays.equals(cur, word) && !mainStr.equals(stringArrayList.get(i).toLowerCase())) {
                anagrams.add(stringArrayList.get(i));
            }
        }
        return anagrams;
    }

    char[] sortCharArray(String s) {
        char[] strArr = s.toLowerCase().toCharArray();
        Arrays.sort(strArr);
        return strArr;
    }
}
