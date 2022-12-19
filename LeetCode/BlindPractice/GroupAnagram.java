class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (var s: strs) {
            List<String> anagrams = new ArrayList<>();
            char[] chrs = s.toCharArray();
            Arrays.sort(chrs);
            String sortedTemp = new String(chrs);
            if (!map.containsKey(sortedTemp)) {
                anagrams.add(s); 
                map.put(sortedTemp, anagrams);
            } else {
                anagrams = map.get(sortedTemp);
                anagrams.add(s);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (var k: map.keySet()) {
            res.add(map.get(k));
        }
        return res;
    }
}
