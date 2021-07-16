/**
 * https://leetcode.com/problems/minimum-path-sum/
 */


class MinimumPathSum {

    static int[][] grid = new int[][] {{1,3,1},
                                       {1,5,1},
                                       {4,2,1}};

    static int[][] grid1 = new int[][] {{1,2,3},
                                        {4,5,6}};

    
    public static void main(String[] args) {
        System.out.println(minPathSum(grid));
        System.out.println(minPathSum(grid1));
    }


    public static int minPathSum(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int[][] dp = new int[rowLen][colLen];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < colLen; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i]; 
        }
        for (int j = 1; j < rowLen; j++) {
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }
        for (int row = 1; row < rowLen; row++) {
            for (int col = 1; col < colLen; col++) {
                dp[row][col] = Math.min(dp[row-1][col], dp[row][col-1]) + grid[row][col];
            }
        }

        return dp[rowLen-1][colLen-1];
    }
}