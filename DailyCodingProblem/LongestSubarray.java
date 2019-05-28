
import java.util.Arrays;
import java.util.HashMap;

/**
 * Author: Mustafa Jamal
 * 
 * This problem was asked by Google.
 * 
 * Given an array of elements, return the length of the longest subarray where all its elements are distinct.
 * For example, given the array [5, 1, 3, 5, 2, 3, 4, 1], return 5 as the longest subarray of distinct elements is [5, 2, 3, 4, 1].
 */

class LongestSubarray {
   
    static int[] mainArray0 = {5, 1, 3, 5, 2, 3, 4, 1};
    static int[] mainArray1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 1};

    static int[] resultArray0 = {5, 2, 3, 4, 1};
    static int[] resultArray1 = {9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) {
        // System.out.println(Arrays.toString(addToHashMap(mainArray1)));
        test(mainArray0);
        test(mainArray1);
    }

    static int[] addToHashMap(int[] array) {
        HashMap hashMap = new HashMap<Integer, Integer>();
        int arrLen = array.length, counter = 0, heighestCount = 0, indexPos = 0;
        for (int i = 0; i < arrLen; i++) {
            for (int j = i; j < arrLen; j++) {
                if (hashMap.containsKey(array[j])) {
                    if (array[arrLen - 1] == array[arrLen - 2]) {
                        indexPos = arrLen - 1 - counter;
                    } else {
                        indexPos = arrLen - counter;
                    }
                    break;
                } else {
                    hashMap.put(array[j], 1);
                    counter++;
                }
            }
            if (heighestCount < counter) {
                heighestCount = counter;
            }
        }
        return Arrays.copyOfRange(array, indexPos, heighestCount + indexPos);
    }

    private static void test(int[] array) {
        if (Arrays.toString(addToHashMap(mainArray0)).equals(Arrays.toString(resultArray0))) {
            System.out.println("DONE");
        } else {
            System.out.println("Error");
        }
    }
}