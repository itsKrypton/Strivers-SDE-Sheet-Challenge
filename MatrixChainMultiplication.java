// https://www.codingninjas.com/codestudio/problems/matrix-chain-multiplication_975344?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

//import java.util.Arrays;

public class MatrixChainMultiplication {
    // Memoization T: Exponential
    /* public static int matrixMultiplication(int[] arr , int N) {
		int[][] dp = new int[N][N];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        return find(1, N - 1, arr, dp);
	}

    // 0   1  2  3  4 
    // 10 20 30 40 50
    public static int find(int i, int j, int[] arr, int[][] dp)
    {
        if(i == j)
        return 0;

        if(dp[i][j] != -1)
        return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++)
        {
            int steps = arr[i - 1] * arr[k] * arr[j] + find(i, k, arr, dp) + find(k + 1, j, arr, dp);
            min = Math.min(min, steps);
        }

        return dp[i][j] = min;
    } */

    //Tabulation T: N^3
    public static int matrixMultiplication(int[] arr , int N) {
		int[][] dp = new int[N][N];

        for(int i = N - 1; i >= 1; i--)
        {
            for(int j = i + 1; j < N; j++)
            {
                int min = Integer.MAX_VALUE;
                for(int k = i; k < j; k++)
                {
                    int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    min = Math.min(min, steps);
                }
        
                dp[i][j] = min;
            }
        }

        return dp[1][N - 1];
	}
}
