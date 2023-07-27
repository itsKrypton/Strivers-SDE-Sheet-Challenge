// https://leetcode.com/problems/minimum-path-sum/

//import java.util.Arrays;

public class MinimumPathSum {
    /* public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        
        for(int row[] : dp)
        Arrays.fill(row, -1);

        return findPaths(grid, grid.length - 1, grid[0].length - 1, dp);
    } */

    //Memoization
    /* public static int findPaths(int[][] grid, int currentX, int currentY, int[][] dp)
    {
        if(currentX == 0 && currentY == 0)
        return grid[0][0];

        if(currentX < 0 || currentY < 0)
        return (int)Math.pow(10,9);

        if(dp[currentX][currentY] != -1)
        return dp[currentX][currentY];

        int left = grid[currentX][currentY] + findPaths(grid, currentX, currentY - 1, dp);
        int up = grid[currentX][currentY] + findPaths(grid, currentX - 1, currentY, dp);

        return dp[currentX][currentY] = Math.min(up, left);
    } */

    //Tabulation
    /* public static int findPaths(int[][] grid, int currentX, int currentY, int[][] dp)
    {
        dp[0][0] = grid[0][0];
        
        for(int i = 0; i <= currentX; i++)
        {
            for(int j = 0; j <= currentY; j++)
            {
                if(!(i == 0 && j == 0))
                {
                    int left = (int)Math.pow(10,9), up = (int)Math.pow(10,9);

                    if(j > 0)
                    left = grid[i][j] + dp[i][j-1];

                    if(i > 0)
                    up = grid[i][j] + dp[i-1][j];

                    dp[i][j] = Math.min(left, up);
                }
            }
        }

        return dp[currentX][currentY];
    } */

    // Space Optimized
    public int minPathSum(int[][] grid) {
        int prev[] = new int[grid[0].length];

        for(int i = 0; i < grid.length; i++)
        {
            int[] temp = new int[grid[0].length];
            temp[0] = grid[0][0];
            for(int j = 0; j < grid[0].length; j++)
            {
                if(!(i == 0 && j == 0))
                {
                    int left = (int)Math.pow(10,9), up = (int)Math.pow(10,9);

                    if(j > 0)
                    left = grid[i][j] + temp[j-1];

                    if(i > 0)
                    up = grid[i][j] + prev[j];

                    temp[j] = Math.min(left, up);
                }
            }
            prev = temp;
        }
        
        return prev[grid[0].length-1];
    }
}
