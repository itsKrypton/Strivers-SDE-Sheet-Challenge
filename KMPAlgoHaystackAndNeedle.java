// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

/*
 * For KMP, we first need to calculate Longest Prefix Suffix array which basically tells us the longest prefix which is equal to suffix before a particular index.
 * See individual lines explanation for LPS. See Neetcode video for understanding it better.
 */

public class KMPAlgoHaystackAndNeedle {
    public int strStr(String haystack, String needle) {
        if(needle == "") return 0;
        int[] lps = new int[needle.length()];

        int prevLPS = 0, i = 1;
        while(i < needle.length())
        {
            if(needle.charAt(i) == needle.charAt(prevLPS)) // If both are same then we know that previous characters match and if current character matched as well then
            {                                              // the answer would be prevLPS + 1
                lps[i] = prevLPS + 1;
                prevLPS++;
                i++;
            }

            else if(prevLPS == 0)              // If not equal and prevLPS was 0 means no previous characters match as well, hence lps for current char would be 0
            {
                lps[i] = 0;
                i++;
            }

            else
            prevLPS = lps[prevLPS - 1];        
        }

        i = 0;
        int j = 0;
        while(i < haystack.length())
        {
            if(haystack.charAt(i) == needle.charAt(j))
            {
                i++;
                j++;
            }

            else
            {
                if(j == 0) 
                i++;

                else
                j = lps[j - 1];
            }

            if(j == needle.length())
            return i - needle.length();
        }

        return -1;
    }
}
