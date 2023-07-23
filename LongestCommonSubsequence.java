// https://leetcode.com/problems/longest-common-subsequence/

//import java.util.Arrays;

public class LongestCommonSubsequence {

    // Memoization
    /* public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        return find(text1.length(), text2.length(), text1, text2, dp);
    }

    public static int find(int n1, int n2, String text1, String text2, int[][] dp)
    {
        if(n1 == 0 || n2 == 0)
        return 0;

        if(dp[n1][n2] != -1)
        return dp[n1][n2];

        if(text1.charAt(n1 - 1) == text2.charAt(n2 - 1))
        return dp[n1][n2] = 1 + find(n1 - 1, n2 - 1, text1, text2, dp);

        return dp[n1][n2] = Math.max(find(n1 - 1, n2, text1, text2, dp), find(n1, n2 - 1, text1, text2, dp));
    } */

    // Tabulation
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];

        for(int i = 1; i <= text1.length(); i++)
        {
            for(int j = 1; j <= text2.length(); j++)
            {
                if(text1.charAt(i - 1) == text2.charAt(j - 1))
                dp[i][j] = 1 + dp[i - 1][j - 1];
        
                else
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // To print the LCS we use the DP array, check https://takeuforward.org/data-structure/print-longest-common-subsequence-dp-26/ to understand.

        /* int i = text1.length(), j = text2.length(), ind = 0;
        int length = dp[text1.length()][text2.length()];

        StringBuilder sb = new StringBuilder();
        for(ind = 0; ind < length; ind++)
        sb.append("$");
        ind--;

        while(i > 0 && j > 0)
        {
            if(text1.charAt(i - 1) == text2.charAt(j - 1))
            {
                sb.setCharAt(ind, text1.charAt(i - 1));
                ind--;
                i--;
                j--;
            }

            else if(dp[i - 1][j] > dp[i][j - 1])
            i--;

            else
            j--;
        }

        System.out.println(sb.toString()); */
        return dp[text1.length()][text2.length()];
    }

    //Space Optimization
    /* public int longestCommonSubsequence(String text1, String text2) {
        int prev[] = new int[text2.length() + 1];

        for(int i = 1; i <= text1.length(); i++)
        {
            int temp[] = new int[prev.length];
            for(int j = 1; j <= text2.length(); j++)
            {
                if(text1.charAt(i - 1) == text2.charAt(j - 1))
                temp[j] = 1 + prev[j - 1];
        
                else
                temp[j] = Math.max(prev[j], temp[j - 1]);
            }
            prev = temp;
        }

        return prev[text2.length()];
    } */
}
