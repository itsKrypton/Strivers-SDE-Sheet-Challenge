import java.util.ArrayList;
//import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {
    // Memoization
    /* public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        int[][] dp = new int[n][n + 1];

        for(int[] i : dp)
        Arrays.fill(i, -1);

        return maxIncreasingSubsequence(0, -1, rack, dp);
    }

    public static int maxIncreasingSubsequence(int index, int prevIndex, ArrayList<Integer> rack, int[][] dp)
    {
        if(index == rack.size()) return 0;

        if(dp[index][prevIndex + 1] != -1)
        return dp[index][prevIndex + 1];

        int take = 0;
        if(prevIndex == -1 || rack.get(prevIndex) < rack.get(index))
        take = rack.get(index) + maxIncreasingSubsequence(index + 1, index, rack, dp);

        int notTake = maxIncreasingSubsequence(index + 1, prevIndex, rack, dp);

        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    } */

    // Tabulation
    /* public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        int[][] dp = new int[n + 1][n + 1];

        for(int i = n - 1; i >= 0; i--)
        {
            for(int j = i - 1; j >= -1; j--)
            {
                int take = 0;
                if(j == -1 || rack.get(j) < rack.get(i))
                take = rack.get(i) + dp[i + 1][i + 1];

                int notTake = dp[i + 1][j + 1];

                dp[i][j + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    } */

    // Space - Optimized
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        int[] next = new int[n + 1];

        for(int i = n - 1; i >= 0; i--)
        {
            int[] temp = new int[next.length];
            for(int j = i - 1; j >= -1; j--)
            {
                int take = 0;
                if(j == -1 || rack.get(j) < rack.get(i))
                take = rack.get(i) + next[i + 1];

                int notTake = next[j + 1];

                temp[j + 1] = Math.max(take, notTake);
            }

            next = temp;
        }

        return next[0];
    }
}
