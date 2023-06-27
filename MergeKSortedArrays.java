import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(ArrayList<Integer> list : kArrays)
		{
			for(int num : list)
			pq.add(num);
		}

		ArrayList<Integer> ans = new ArrayList<>();

		while(!pq.isEmpty())
		ans.add(pq.remove());

		return ans;
	}
}
