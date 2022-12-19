 // 1. Two Sum
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int key = target - cur;
            if (map.containsKey(key)) return new int[]{map.get(key), i};
            map.put(cur, i);
        }
        return null;
    }
}
