/** 
* problem: 42 
* Trapping Rain Water: https://leetcode.com/problems/trapping-rain-water/submissions/860256461/
*/
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int leftP = 0;
        int rightP = height.length - 1;

        int leftMax = height[leftP];
        int rightMax = height[rightP];

        while (leftP < rightP) {
            if (leftMax < rightMax) {
                leftP++;
                leftMax = Math.max(leftMax, height[leftP]);
                ans += leftMax - height[leftP];
            } else {
                rightP--;
                rightMax = Math.max(rightMax, height[rightP]);
                ans += rightMax - height[rightP];
            }
        }

        return ans;
    }
}

// Time complexity: O(N)
// Space complexity: O(1)
