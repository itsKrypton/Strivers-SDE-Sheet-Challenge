// Cam be done in O(n) avg time by quickselect, need to learn

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KthSmallestAndLargestElement {
    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(0);
		ans.add(0);

		int smallest = k, largest = n - k + 1;
        for(int num : arr)
        pQueue.add(num);

        while(!pQueue.isEmpty())
		{
			largest--;
			smallest--;
			
			int currElement = pQueue.poll();

			if(smallest == 0) ans.set(0, currElement);
			if(largest == 0) ans.set(1, currElement);
		}

        return ans;
	}
}
