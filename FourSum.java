// https://leetcode.com/problems/4sum/description/ 

/* 
 * Keep two indexes fixed and move the third one to find the fourth one which equals to the given total.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        HashSet<List<Integer>> mySet = new HashSet<>();

        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i + 1; j < nums.length; j++)
            {
                HashSet<Long> set = new HashSet<>();
                for(int k = j + 1; k < nums.length; k++)
                {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[k];
                    long fourth = target - sum;

                    if(set.contains(fourth))
                    {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int)fourth);
                        Collections.sort(temp);

                        if(mySet.add(temp)) answer.add(temp);;
                    }

                    set.add((long)nums[k]);
                }
            }
        }

        return answer;
    }
}
