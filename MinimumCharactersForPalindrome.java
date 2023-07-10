/*
 * We use LPS array from KMP Algo to solve this problem. We pass the input string by adding an $ (temp value) and the reverse of input string at the end of it. The last
 * value of the LPS array will tell that which is the longest prefix of that array which is also the suffix and length of input string - this value will be our answer.
 */ 

public class MinimumCharactersForPalindrome {
    public static int minCharsforPalindrome(String str) {
        String s = str + "$" + new StringBuilder(str).reverse().toString();
        return (str.length() - lastValueLPS(s));
    }

    public static int lastValueLPS(String s)
    {
        if(s == "") return 0;
        int[] lps = new int[s.length()];

        int prevLPS = 0, i = 1;
        while(i < s.length())
        {
            if(s.charAt(i) == s.charAt(prevLPS))
            {
                lps[i] = prevLPS + 1;
                prevLPS++;
                i++;
            }

            else if(prevLPS == 0)
            {
                lps[i] = 0;
                i++;
            }

            else
            prevLPS = lps[prevLPS - 1];        
        }

        return lps[lps.length - 1];
    }
}
