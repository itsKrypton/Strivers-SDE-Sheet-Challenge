/*
 * Take the sliding window of size k and add that to hashtable along with their frequencies. At every shift of the window, reduce the frequency of the element that left
 * the window and add the element/increase frequency of the next element in the window. If any elements frequency gets to 0 when reducing then remove that element from
 * map. The size of the map shows the distinct elements currently present in the window.
 */

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctElementInKSizeWindow {
    public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> ans = new ArrayList<>();

		for(int i = 0; i < arr.size(); i++)
		{
			if(i >= k)
			{
				int prev = arr.get(i - k);

				map.put(prev, map.get(prev) - 1);

				if(map.get(prev) == 0)
				map.remove(prev);
			}

			int current = arr.get(i);
			map.put(current, map.getOrDefault(current, 0) + 1);

			if(i >= k - 1)
			ans.add(map.size());
		}

		return ans;
	}
}
