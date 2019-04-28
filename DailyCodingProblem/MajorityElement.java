/**
 * Author: Mustafa Jamal
 * April 28, 2019
 * 
 * This problem was asked by MongoDB.
 * 
 * Given a list of elements, find the majority element, which appears more than half the time (> floor(len(lst) / 2.0)).
 * You can assume that such element exists.
 * For example, given [1, 2, 1, 1, 3, 4, 0], return 1.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.Map.Entry;
import java.util.Comparator;
import java.util.PriorityQueue;


class MajorityElement {
    
    static Integer[] elementsList = new Integer[] {1, 2, 1, 1, 3, 4, 0};    // New arrays for testing added here

    static List<Integer> elements = new ArrayList<Integer>();
    private static Integer firstMajorElement;
    private static Integer secondMajorElement;
    private static Integer firstMajorElementOccurrence;
    private static Integer secondMajorElementOccurrence;

    public static void main(String[] args) {
        elements.addAll(Arrays.asList(elementsList));
        mostCommon(elements);

        if (Math.floor(firstMajorElementOccurrence / secondMajorElementOccurrence) > 2.0) {
            System.out.println(firstMajorElement);
        } else {
            System.out.println("Nope!");
        }

    }

    public static void mostCommon(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer t : list) {
            Integer val = map.get(t);
            map.put(t, val == null ? 1 : val + 1);
        }
        firstMajorElement = 0;
        maxUsingCollectionsMaxAndLambda(map);
    }

    static void maxUsingCollectionsMaxAndLambda(Map<Integer, Integer> map) {
        Entry<Integer, Integer> maxEntry = Collections.max(map.entrySet(), (Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) -> e1.getValue().compareTo(e2.getValue()));
        firstMajorElement = maxEntry.getKey();
        firstMajorElementOccurrence = maxEntry.getValue();
        map.remove(maxEntry.getKey());
        Entry<Integer, Integer> secMaxEntry = Collections.max(map.entrySet(), (Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) -> e1.getValue().compareTo(e2.getValue()));
        secondMajorElement = secMaxEntry.getKey();
        secondMajorElementOccurrence = secMaxEntry.getValue();
    }
}
