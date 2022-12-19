class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> feqMap = new HashMap<>();
        for (var n: nums) {
            feqMap.putIfAbsent(n, 0);
            feqMap.put(n, feqMap.get(n) + 1);
        }

        LinkedHashMap<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();
        feqMap.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k)
        .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        return new ArrayList<>(reverseSortedMap.keySet()).stream().mapToInt(i -> i).toArray();        
    }
}
