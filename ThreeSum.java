import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {
		ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

		Arrays.sort(arr);

	    for(int i = 0; i < arr.length - 2; i++)
		{
			if(i == 0 || (i>0 && arr[i] != arr[i-1]))
			{
				int low = i + 1, high = arr.length - 1;
				while(low < high)
				{
					int total = arr[i] + arr[low] + arr[high];

					if(total > K) high--;

					else if(total < K) low++;

					else
					{
						ArrayList<Integer> triplet = new ArrayList<>();
						triplet.add(arr[i]);
						triplet.add(arr[low]);
						triplet.add(arr[high]);
						
						answer.add(triplet);

						while(low < high && arr[low] == arr[low + 1]) low++;
						while(low < high && arr[high] == arr[high - 1]) high--;
						low++;
						high--;
					}
				}
			}
		}

		return answer;
	}
}
