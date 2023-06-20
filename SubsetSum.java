import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum {
    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        sum(num.length - 1, num, 0, ans);

        Collections.sort(ans);
        return ans;
    }

    public static void sum(int index, int num[], int currSum, ArrayList<Integer> ans)
    {
        if(index < 0)
        {
            ans.add(currSum);
            return;
        }

        sum(index - 1, num, currSum + num[index], ans);
        sum(index - 1, num, currSum, ans);
    }
}
