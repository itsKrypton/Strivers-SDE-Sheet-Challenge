// https://www.codingninjas.com/codestudio/problems/longest-subarray-zero-sum_8230747?challengeSlug=striver-sde-challenge&leftPanelTab=0

/*
 * Look for prefsum, if two prefsums are same then then the elements between them will definitely add up to be zero if you think logically. Thus, save the prefsum and
 * check everytime if you have seen this prefsum before, if you have, then the current length of subarray would be the difference of indexes between them. Return longest
 * length.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class LongestSubarrayZeroSum {
    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int maxLength = 0;
        int sum = 0;
        for(int i = 0; i < arr.size(); i++)
        {
            sum += arr.get(i);
            if(map.containsKey(sum)) maxLength = Math.max(maxLength, i + 1 - map.get(sum));

            else
            map.put(sum, i + 1);
        }

        return maxLength;
	}
}
