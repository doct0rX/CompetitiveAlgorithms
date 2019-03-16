/**
 * https://leetcode.com/contest/weekly-contest-127/problems/maximize-sum-of-array-after-k-negations/
 */

class MaximizeSumOfArrayAfterKNegations {

    public int largestSumAfterKNegations(int[] A, int K) {
        while(K--!=0){
            Arrays.sort(A);
            A[0]*=-1;                
        }                
     return IntStream.of(A).sum();
    }
}