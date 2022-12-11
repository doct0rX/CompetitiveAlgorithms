// problem #1423

class Solution {

    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int frontScore, rearScore, maxScore;

        frontScore = Arrays.stream(cardPoints, 0 , k).sum();
        maxScore = frontScore;
        rearScore = 0;

        for (int i = k - 1; i >= 0; i--) {
            rearScore += cardPoints[len - k + i];
            frontScore -= cardPoints[i];
            maxScore = Math.max(frontScore + rearScore, maxScore);
        }
        return maxScore;
    }
}


// time complexity: O(2.k) => O(k)
// space complexity: O(1)
