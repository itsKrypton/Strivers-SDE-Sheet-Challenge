//import java.util.Arrays;

public class PalindromePartitioningII {
    /* public int minCut(String s) {
        int[] dp = new int[s.length()];

        Arrays.fill(dp, -1);

        return find(0, s.length() - 1, s, dp);
    }

    public static int find(int i, int j, String s, int[] dp)
    {
        if(i == j)
        return 0;
        
        if(isPalindrome(i, j, s))
        return 0;
        
        if(dp[i] != -1)
        return dp[i];

        int count = Integer.MAX_VALUE;
        for(int k = i; k < j; k++)
        {
            if(isPalindrome(i, k, s))
            count = Math.min(count, 1 + find(k + 1, j, s, dp));
        }

        return dp[i] = count;
    } */

    /* public int minCut(String s) {
        int[] dp = new int[s.length() + 1];

        for(int i = s.length() - 1; i >= 0; i--)
        {
            int count = Integer.MAX_VALUE;

            for(int k = i; k < s.length(); k++)
            {
                if(isPalindrome(i, k, s))
                count = Math.min(count, 1 + dp[k + 1]);
            }
    
            dp[i] = count;        
        }

        return dp[0] - 1;
    }

    public static boolean isPalindrome(int i, int j, String s)
    {
        while(i < j)
        {
            if(s.charAt(i++) != s.charAt(j--))
            return false;
        }

        return true;
    } */

    // Precomputed palindromes to optimize time taken
    public int minCut(String s) {
        boolean[][] palindromeDP = new boolean[s.length()][s.length()]; 
        int[] dp = new int[s.length() + 1];

        isPalindrome(palindromeDP, s);

        for(int i = s.length() - 1; i >= 0; i--)
        {
            int count = Integer.MAX_VALUE;

            for(int k = i; k < s.length(); k++)
            {
                if(palindromeDP[i][k])
                count = Math.min(count, 1 + dp[k + 1]);
            }
    
            dp[i] = count;        
        }

        return dp[0] - 1;
    }

    public static void isPalindrome(boolean[][] palindromeDP, String s)
    {
        for(int i = 0; i < s.length(); i++)
        {
            palindromeDP[i][i] = true;
            for(int j = i - 1, k = i + 1; j >= 0 && k < s.length(); j--, k++)
            {
                if(s.charAt(j) == s.charAt(k))
                palindromeDP[j][k] = true;

                else
                break;
            }

            for(int j = i, k = i + 1; j >= 0 && k < s.length(); j--, k++)
            {
                if(s.charAt(j) == s.charAt(k))
                palindromeDP[j][k] = true;

                else
                break;
            }
        }
    }
}