// https://leetcode.com/problems/longest-common-prefix/description/

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;

        mainloop:
        for(i = 0; i < strs[0].length(); i++)
        {
            char ch = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++)
            {
                if(i >= strs[j].length() || ch != strs[j].charAt(i))
                break mainloop;
            }
        }

        return strs[0].substring(0, i);
    }
}
