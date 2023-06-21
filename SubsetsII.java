// https://leetcode.com/problems/subsets-ii/submissions/976104703/

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.HashSet;
import java.util.List;

public class SubsetsII {

    // Using hashset to avoid duplicates, takes more space

    /* public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> currentList = new ArrayList<>();

        Arrays.sort(nums);
        
        subsets(0, nums, currentList, set, answer);

        return answer;
    }

    public static void subsets(int index, int[] nums, List<Integer> currentList, HashSet<List<Integer>> set, List<List<Integer>> answer)
    {
        if(index == nums.length)
        {
            if(set.add(new ArrayList<>(currentList)))
            answer.add(new ArrayList<>(currentList));

            return;
        }

        currentList.add(nums[index]);
        subsets(index + 1, nums, currentList, set, answer);
        currentList.remove(currentList.size() - 1);
        subsets(index + 1, nums, currentList, set, answer);
    } */

    // Without hashset, sorting the input array and avoiding duplicates.
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();

        Arrays.sort(nums);

        subsets(0, nums, currentList, answer);

        return answer;
    }

    public void subsets(int index, int[] nums, List<Integer> currentList, List<List<Integer>> answer)
    {
        answer.add(new ArrayList<>(currentList));

        for(int i = index; i < nums.length; i++)
        {
            if(i != index && nums[i] == nums[i - 1]) continue;

            currentList.add(nums[i]);
            subsets(i + 1, nums, currentList, answer);
            currentList.remove(currentList.size() - 1);
        }
    }
}
