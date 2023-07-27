// https://leetcode.com/problems/edit-distance/description/

//import java.util.Arrays;

public class EditDistance {

    //Memoization

    /* public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];

        for(int[] i : dp)
        Arrays.fill(i, -1);

        return find(word1.length() - 1, word2.length() - 1, word1, word2, dp);
    }

    public static int find(int n, int m, String word1, String word2, int[][] dp)
    {
        if(n < 0)
        return m + 1;

        if(m < 0)
        return n + 1;

        if(dp[n][m] != -1)
        return dp[n][m];

        int match = Integer.MAX_VALUE;
        if(word1.charAt(n) == word2.charAt(m))
        match = find(n - 1, m - 1, word1, word2, dp);

        int insert = 1 + find(n, m - 1, word1, word2, dp);
        int remove = 1 + find(n - 1, m, word1, word2, dp);
        int replace = 1 + find(n - 1, m - 1, word1, word2, dp);

        return dp[n][m] = Math.min(Math.min(match, insert), Math.min(remove, replace));
    } */

    // Tabulation here we will be shifting the indexing to right by one as base case is < 0 which is not possible for dp array
    /* public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 0; i <= word2.length(); i++)
        dp[0][i] = i;

        for(int i = 1; i <= word1.length(); i++)
        dp[i][0] = i;

        for(int i = 1; i <= word1.length(); i++)
        {
            for(int j = 1; j <= word2.length(); j++)
            {
                int match = Integer.MAX_VALUE;
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                match = dp[i - 1][j - 1];
        
                int insert = 1 + dp[i][j - 1];
                int remove = 1 + dp[i - 1][j];
                int replace = 1 + dp[i - 1][j - 1];
        
                dp[i][j] = Math.min(Math.min(match, insert), Math.min(remove, replace));     
            }
        }

        return dp[word1.length()][word2.length()];
    } */

    //Space Optimization
    public int minDistance(String word1, String word2) {
        int prev[] = new int[word2.length() + 1];

        for(int i = 0; i <= word2.length(); i++)
        prev[i] = i;

        for(int i = 1; i <= word1.length(); i++)
        {
            int temp[] = new int[prev.length];
            temp[0] = i;
            for(int j = 1; j <= word2.length(); j++)
            {
                int match = Integer.MAX_VALUE;
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                match = prev[j - 1];
        
                int insert = 1 + temp[j - 1];
                int remove = 1 + prev[j];
                int replace = 1 + prev[j - 1];
        
                temp[j] = Math.min(Math.min(match, insert), Math.min(remove, replace));     
            }
            prev = temp;
        }

        return prev[word2.length()];
    }
}
