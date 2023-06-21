import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;

// Here the elements in the array are distinct and not repeated


public class CombinationSum {
    // https://leetcode.com/problems/combination-sum/description/
    /* public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answers = new ArrayList<>();
        combinations(candidates, target, new ArrayList<>(), answers, 0);

        return answers;
    }

    public static void combinations(int[] candidates, int target, List<Integer> answer, List<List<Integer>> answers, int index)
    {
        if(target == 0)
        {
            answers.add(new ArrayList<>(answer));
            return;
        }

        for(int i = index; i < candidates.length; i++)
        {
            if(candidates[i] > target) break;

            answer.add(candidates[i]);
            combinations(candidates, target - candidates[i], answer, answers, i);
            answer.remove(answer.size() - 1);
        }
    } */

    // https://www.codingninjas.com/studio/problems/return-subsets-sum-to-k_8230706?challengeSlug=striver-sde-challenge&leftPanelTab=0

    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) 
	{
        ArrayList<ArrayList<Integer>> answers = new ArrayList<>();
        combinations(arr, k, new ArrayList<>(), answers, 0);

        return answers;
    }

    public static void combinations(ArrayList<Integer> arr, int k, ArrayList<Integer> answer, ArrayList<ArrayList<Integer>> answers, int index)
    {
        if(k == 0)
        answers.add(new ArrayList<>(answer));

        for(int i = index; i < arr.size(); i++)
        {
            answer.add(arr.get(i));
            combinations(arr, k - arr.get(i), answer, answers, i + 1);
            answer.remove(answer.size() - 1);
        }
    }

    //or

    /* public static void combinations(ArrayList<Integer> arr, int k, ArrayList<Integer> answer, ArrayList<ArrayList<Integer>> answers, int index)
    {
        if(index == arr.size())
        {
            if(k == 0)
            answers.add(new ArrayList<>(answer));

            return;
        }

        
        answer.add(arr.get(index));
        combinations(arr, k - arr.get(index), answer, answers, index + 1);
        answer.remove(answer.size() - 1);
        combinations(arr, k, answer, answers, index + 1);
    } */

}
