// 217. Contains Duplicate
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().toList());
        return set.size() != nums.length;
    }
}
