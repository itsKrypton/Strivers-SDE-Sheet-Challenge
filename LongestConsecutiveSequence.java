// https://leetcode.com/problems/longest-consecutive-sequence/description/

/*
 * Add all of the numbers in a hashset for O(1) lookup. Run a loop and for every number check if its the start of a series, if it's not then check the length of its
 * series and at the end return the longest series.
 */

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums)
        set.add(i);

        int longestStreak = 0;
        for(int i : nums)
        {
            if(!set.contains(i - 1))
            {
                int currentStreak = 1;
                int currentNumber = i;

                while(set.contains(currentNumber + 1))
                {
                    currentStreak++;
                    currentNumber++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
