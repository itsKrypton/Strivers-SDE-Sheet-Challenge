//import java.util.Arrays;
import java.util.Hashtable;

public class FourElementsSumEqualToTarget {

    // No extra space but time is O(n^3)
    /* public static String fourSum(int[] arr, int target, int n) {
        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i + 1; j < arr.length; j++)
            {
                int low = j + 1, high = arr.length - 1;

                while(low < high)
                {
                    long sum = (long)arr[i] + (long)arr[j] + (long)arr[low] + (long)arr[high];

                    if(sum > target) high--;

                    else if(sum < target) low++;

                    else
                    return "Yes";
                }
            }
        }

        return "No";
    }  */

    // Space and time is n^2
    public String fourSum(int[] arr, int target, int n) {
        Hashtable<Integer, Pair> set = new Hashtable<>();
        
        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                int remainder = target - arr[i] - arr[j];

                if(set.containsKey(remainder) && i != set.get(remainder).first && j != set.get(remainder).second) return "Yes";

                else
                set.put(remainder, new Pair(i, j));
            }
        }

        return "No";
    } 

    class Pair {
        private int first;
        private int second;

        public Pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
}
