// https://leetcode.com/problems/longest-palindromic-substring/description/

//import java.util.Arrays;

/*
 * Start from the every index and traverse to the left and right until the characters are same, if the length is greater than previous max length then we update the maxlength.
 * We do this for both even and odd palindromic strings and return the final string.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        Pair maxString = new Pair(0, 0);

        for(int i = 0; i < s.length(); i++)
        {
            findMaxPalindrome(s, i, i, maxString); // Odd strings
            findMaxPalindrome(s, i, i + 1, maxString); // Even strings
        }

        return s.substring(maxString.startIndex, maxString.startIndex + maxString.length);
    }

    public void findMaxPalindrome(String s, int left, int right, Pair maxString)
    {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }

        if(right - left - 1 > maxString.length)
        {
            maxString.startIndex = left + 1;
            maxString.length = right - left - 1;
        }

        return;
    }

    public class Pair {
        private int startIndex;
        private int length;

        public Pair(int startIndex, int length)
        {
            this.startIndex = startIndex;
            this.length = length;
        }
    }

    // or

    /* public String longestPalindrome(String s) {
        int[] maxLength = new int[2]; // 0 for startIndex, 1 for length

        for(int i = 0; i < s.length(); i++)
        {
            findMaxPalindrome(s, i, i, maxLength);
            findMaxPalindrome(s, i, i + 1, maxLength);
        }

        return s.substring(maxLength[0], maxLength[0] + maxLength[1]);
    }

    public void findMaxPalindrome(String s, int left, int right, int[] maxLength)
    {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }

        if(right - left - 1 > maxLength[1])
        {
            maxLength[0] = left + 1;
            maxLength[1] = right - left - 1;
        }

        return;
    } */
}
