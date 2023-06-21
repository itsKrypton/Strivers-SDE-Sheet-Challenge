// https://leetcode.com/problems/palindrome-partitioning/description/

import java.util.ArrayList;
import java.util.List;

/*
 * At every index, check whether the substring till there is a palindrome, if it is then take that to the list and check the rest of the string. At the last index,
 * it to the answers.
 */

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> answers = new ArrayList<>();

        helper(0, s, new ArrayList<>(), answers);

        return answers;
    }

    public static void helper(int index, String s, List<String> answer, List<List<String>> answers)
    {
        if(index == s.length())
        {
            answers.add(new ArrayList<>(answer));
            return;
        }

        for(int i = index; i < s.length(); i++)
        {
            if(isPalindrome(s, index, i))
            {
                answer.add(s.substring(index, i + 1));
                helper(i + 1, s, answer, answers);
                answer.remove(answer.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) 
    {
        while(start < end)
        {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }
}
