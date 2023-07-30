// https://leetcode.com/problems/word-break/submissions/

//import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * Store words in hashset and start a loop from start to end of the input word, at the point where you find a word, recursively solve the rest of the string to check
 * if the words exist from the remaining string.
 */

public class WordBreak {
    // Memoization
    /* public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);

        for(String word : wordDict)
        set.add(word);

        return find(0, s, set, dp);
    }

    public boolean find(int index, String word, HashSet<String> set, int[] dp)
    {
        if(index == word.length())
        return true;

        if(dp[index] != -1)
        return (dp[index] == 1) ? true : false;

        for(int i = index + 1; i <= word.length(); i++)
        {
            if(set.contains(word.substring(index, i)) && find(i, word, set, dp))
            {
                dp[index] = 1;
                return true;
            }
        }

        dp[index] = 0;
        return false;
    } */

    // Tabulation
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for(int index = s.length() - 1; index >= 0; index--)
        {
            for(int i = index + 1; i <= s.length(); i++)
            {
                if(set.contains(s.substring(index, i)) && dp[i])
                {
                    dp[index] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
