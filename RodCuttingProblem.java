// https://www.codingninjas.com/studio/problems/rod-cutting-problem_8230727?challengeSlug=striver-sde-challenge&leftPanelTab=1

//import java.util.Arrays;

public class RodCuttingProblem {
    // Memoization
    /* public static int cutRod(int price[], int n) {
		int[][] dp = new int[n + 1][n + 1];

		for(int i[] : dp)
		Arrays.fill(i, -1);

		return find(0, n, price, dp);
	}

	public static int find(int index, int pieces, int[] price, int[][] dp)
	{
		if(index >= price.length || pieces == 0)
		return 0;

		if(dp[index][pieces] != -1)
		return dp[index][pieces];

		int pick = 0;
		if(pieces - index - 1 >= 0)
		pick = price[index] + find(index, pieces - index - 1, price, dp);

		int notPick = find(index + 1, pieces, price, dp);

		return dp[index][pieces] = Math.max(pick, notPick);
	} */

    // Tabulation
    /* public static int cutRod(int price[], int n) {
		int[][] dp = new int[n + 1][n + 1];

		for(int i = n - 1; i >= 0; i--)
		{
			for(int j = 1; j <= n; j++)
			{
				int pick = 0;
				if(j - i - 1 >= 0)
				pick = price[i] + dp[i][j - i - 1];

				int notPick = dp[i + 1][j];

				dp[i][j] = Math.max(pick, notPick);
			}
		}

		return dp[0][n];
	} */

    // Space - Optimized
    public static int cutRod(int price[], int n) {
		int[] next = new int[n + 1];

		for(int i = n - 1; i >= 0; i--)
		{
			int[] temp = new int[next.length];
			for(int j = 1; j <= n; j++)
			{
				int pick = 0;
				if(j - i - 1 >= 0)
				pick = price[i] + temp[j - i - 1];

				int notPick = next[j];

				temp[j] = Math.max(pick, notPick);
			}
			next = temp;
		}

		return next[n];
	}

}