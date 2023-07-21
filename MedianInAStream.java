// Same as FindMedianFromDataStream

import java.util.PriorityQueue;

public class MedianInAStream {
    public static int[] findMedian(int[] arr, int n) {
		PriorityQueue<Integer> small = new PriorityQueue<Integer>((a,b) -> Integer.compare(b, a));
    	PriorityQueue<Integer> large = new PriorityQueue<Integer>();
        int[] ans = new int[n];
        int idx = 0;

		for(int num : arr)
		{
			if(small.isEmpty())
			small.add(num);

			else if(num > small.peek() && (large.isEmpty() || num >= large.peek()))
			large.add(num);

			else
			small.add(num);

			if(Math.abs(small.size() - large.size()) > 1)
			{
				if(small.size() > large.size())
				large.add(small.remove());

				else
				small.add(large.remove());
			}

			ans[idx++] = findMedian(small, large);
		}

        return ans;
    }
	public static int findMedian(PriorityQueue<Integer> small, PriorityQueue<Integer> large) {
        return ((small.size() + large.size()) % 2 == 0) ? (small.peek() + large.peek()) / 2 : 
        (small.size() > large.size()) ? small.peek() : large.peek();
    }
}
