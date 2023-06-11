import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class PairSum {
    public static void main(String[] args) {
        List<int[]> answer = pairSum(new int[]{2, -3, 3, 3, -2}, 0);
        
        for(int[] i : answer)
        System.out.println(Arrays.toString(i));
    }

    public static List<int[]> pairSum(int[] arr, int s) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        List<int[]> ans = new ArrayList<>();

        for(int i : arr)
        {
            if(table.containsKey(i))
            {
                for(int j = 0; j < table.get(i); j++)
                {
                    int[] temp = ((s - i) > i) ? new int[]{i, s - i} : new int[]{s - i, i};
                    ans.add(temp);
                }
            }

            table.put(s - i, table.getOrDefault(s - i, 0) + 1);
        }

        Collections.sort(ans, (a,b) -> Integer.compare(a[0], b[0]));
        return ans;
    }
}
