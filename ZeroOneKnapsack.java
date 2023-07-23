// https://www.codingninjas.com/codestudio/problems/0-1-knapsack_920542?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
//import java.util.Arrays;

public class ZeroOneKnapsack {

    // Memoization
    /* static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        return find(n - 1, maxWeight, value, weight, dp);
    } */

    /* public static int find(int n, int maxWeight, int[] value, int[] weight, int[][] dp)
    {
        if(maxWeight == 0)
        return 0;

        if(n == 0)
        return (weight[n] <= maxWeight) ? value[n] : 0;

        if(dp[n][maxWeight] != -1)
        return dp[n][maxWeight];

        int pick = 0;
        if(weight[n] <= maxWeight)
        pick = value[n] + find(n - 1, maxWeight - weight[n], value, weight, dp);

        int notPick = find(n - 1, maxWeight, value, weight, dp);

        return dp[n][maxWeight] = Math.max(pick, notPick);
    } */

    // Tabulation
    /* static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];

        for(int i = weight[0]; i <= maxWeight; i++)
        dp[0][i] = value[0];

        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j <= maxWeight; j++)
            {
                int pick = 0;
                if(weight[i] <= j)
                pick = value[i] + dp[i - 1][j - weight[i]];
        
                int notPick = dp[i - 1][j];
        
                dp[i][j] = Math.max(pick, notPick);
            }
        }

        return dp[n - 1][maxWeight];
    } */

    // Space Optimized
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight + 1];

        for(int i = weight[0]; i <= maxWeight; i++)
        prev[i] = value[0];

        for(int i = 1; i < n; i++)
        {
            int temp[] = new int[prev.length];
            for(int j = 0; j <= maxWeight; j++)
            {
                int pick = 0;
                if(weight[i] <= j)
                pick = value[i] + prev[j - weight[i]];
        
                int notPick = prev[j];
        
                temp[j] = Math.max(pick, notPick);
            }
            prev = temp;
        }

        return prev[maxWeight];
    }
}
