// https://leetcode.com/problems/combination-sum-ii/description/ and https://www.codingninjas.com/studio/problems/combination-sum-ii_8230820?challengeSlug=striver-sde-challenge&leftPanelTab=0

/*
 * Here elements in the given array may be repeated.
 */

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSumII {
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
        ArrayList<ArrayList<Integer>> answers = new ArrayList<>();
        Collections.sort(arr);
        combinations(arr, target, new ArrayList<>(), answers, 0);

        return answers;
    }

    public static void combinations(ArrayList<Integer> candidates, int target, ArrayList<Integer> answer, ArrayList<ArrayList<Integer>> answers, int index)
    {
        if(target == 0)
        {
            answers.add(new ArrayList<>(answer));
            return;
        }

        for(int i = index; i < candidates.size(); i++)
        {
            if(candidates.get(index) > target) break;

            if(i != index && candidates.get(i) == candidates.get(i - 1)) continue;

            answer.add(candidates.get(i));
            combinations(candidates, target - candidates.get(i), answer, answers, i + 1);
            answer.remove(answer.size() - 1);
        }
    }
}
