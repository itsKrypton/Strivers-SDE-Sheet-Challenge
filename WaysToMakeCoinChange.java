// https://www.codingninjas.com/studio/problems/ways-to-make-coin-change_8230691?challengeSlug=striver-sde-challenge&leftPanelTab=1

//import java.util.Arrays;

public class WaysToMakeCoinChange {
    // Memoization
    /* public static long countWaysToMakeChange(int denominations[], int value){
        long[][] dp = new long[denominations.length][value + 1];

        for(long i[] : dp)
        Arrays.fill(i, -1);

        return find(denominations.length - 1, value, denominations, dp);
	}

	public static long find(int n, int amount, int[] coins, long[][] dp)
    {
        if(n == 0)
        return (amount % coins[0] == 0) ? 1 : 0;

        if(dp[n][amount] != -1)
        return dp[n][amount];

        long pick = 0;
        if(coins[n] <= amount)
        pick = find(n, amount - coins[n], coins, dp);

        long notPick = find(n - 1, amount, coins, dp);

        return dp[n][amount] = pick + notPick;
    } */

    // Tabulation
    /* public static long countWaysToMakeChange(int denominations[], int value){
        long[][] dp = new long[denominations.length][value + 1];

        for(int j = 0; j <= value; j++)
		dp[0][j] = (j % denominations[0] == 0) ? 1 : 0;

		for(int i = 1; i < denominations.length; i++)
		{
			for(int j = 0; j <= value; j++)
			{
				long pick = 0;
				if(denominations[i] <= j)
				pick = dp[i][j - denominations[i]];

				long notPick = dp[i - 1][j];

				dp[i][j] = pick + notPick;
			}
		}

        return dp[denominations.length - 1][value];
	} */

    // Space - Optimized
    public static long countWaysToMakeChange(int denominations[], int value){
        long[] prev = new long[value + 1];

        for(int j = 0; j <= value; j++)
		prev[j] = (j % denominations[0] == 0) ? 1 : 0;

		for(int i = 1; i < denominations.length; i++)
		{
			long[] temp = new long[prev.length];
			for(int j = 0; j <= value; j++)
			{
				long pick = 0;
				if(denominations[i] <= j)
				pick = temp[j - denominations[i]];

				long notPick = prev[j];

				temp[j] = pick + notPick;
			}
			prev = temp;
		}

        return prev[value];
	}
}
