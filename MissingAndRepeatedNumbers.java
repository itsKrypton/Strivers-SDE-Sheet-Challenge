import java.util.ArrayList;

public class MissingAndRepeatedNumbers {
    // This approach uses extra space, need to learn the optimal approach.
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int[] hash = new int[n + 1];

        for(int i : arr)
        hash[i]++;

        int[] answer = new int[2];
        for(int i = 1; i <= n; i++)
        {
            if(hash[i] == 2) answer[1] = i;

            else if(hash[i] == 0) answer[0] = i;
        }

        return answer;
    }
}
