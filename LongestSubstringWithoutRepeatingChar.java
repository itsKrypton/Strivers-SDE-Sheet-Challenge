import java.util.HashMap;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.Queue;

public class LongestSubstringWithoutRepeatingChar {
    // O(n) time but uses O(n) + O(n) space
    /* public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>(); 
        HashSet<Character> set = new HashSet<>();  

        int maxLength = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(set.contains(ch))
            {
                while(set.contains(ch))
                set.remove(queue.poll());
            }

            set.add(ch);
            queue.add(ch);
            maxLength = Math.max(maxLength, queue.size());
        }

        return maxLength;
    } */

    // O(n + n) time and  O(n) space, eliminated need of queue with two pointers.
    /* public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();  

        if(s.length() == 0) return 0;
        
        int maxLength = 1;
        int low = 0;
        set.add(s.charAt(low));

        for(int high = 1; high < s.length(); high++)
        {
            char ch = s.charAt(high);
            if(set.contains(ch))
            {
                while(set.contains(ch))
                set.remove(s.charAt(low++));
            }

            set.add(ch);
            maxLength = Math.max(maxLength, high - low + 1);
        }

        return maxLength;
    } */

    // Most efficient O(n) time and space
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> set = new HashMap<>();  
        
        int maxLength = 0;
        int low = 0;

        for(int high = 0; high < s.length(); high++)
        {
            char ch = s.charAt(high);
            
            if(set.containsKey(ch) && set.get(ch) >= low)
            low = set.get(ch) + 1;

            set.put(ch, high);
            maxLength = Math.max(maxLength, high - low + 1);
        }

        return maxLength;
    }
}
