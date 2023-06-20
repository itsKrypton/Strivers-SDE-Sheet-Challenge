// https://leetcode.com/problems/max-consecutive-ones-iii/description/

/*
 * Sliding Window, increase width as long as you get 1's and 0's (if k > 0). If k == 0 then decrease the window till k > 0 and continue.
 */

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int low = 0, high = 0, maxLength = 0;

        while(high < nums.length)
        {
            if(nums[high] == 0)
            {
                if(k == 0)
                {
                    while(low < nums.length && nums[low] != 0) low++;
                    low++;
                    k++;
                }

                k--;
            }

            maxLength = Math.max(high - low + 1, maxLength);
            high++;
        }

        return maxLength;
    }
}
