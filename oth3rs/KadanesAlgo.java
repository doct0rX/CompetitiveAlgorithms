import java.util.Arrays;

class KadenesAlgo {

    static int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};


    public static void main(String[] args) {
        System.out.println(Arrays.toString(kadenes(arr)));
    }


    static int[] kadenes(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int bestStart = 0, bestEnd = 0;
        int currSum = 0;
        int currStart = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currSum <= 0) {     // start a new sequence at current element
                currStart = i;
                currSum = nums[i];
            } else         // extend the existing sequence w/ the current element
                currSum += nums[i];
            
            if (currSum > maxSum) {
                maxSum = currSum;
                bestStart = currStart;
                bestEnd = i + 1; // +1 to make bestEnd exclusive
            }

        }
        return  new int[] {maxSum, bestStart, bestEnd};
    }
}