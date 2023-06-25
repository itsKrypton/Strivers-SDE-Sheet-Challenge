/*
 * Find the lower limit and upper limit from the entire matrix. Using BS, find the mid value and see how many elements including that number lie on the left to it
 * using another binary search.
 */

import java.util.ArrayList;

public class MatrixMedian {
    public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
		for(int i = 0; i < matrix.size(); i++)
		{
			low = Math.min(low, matrix.get(i).get(0));
			high = Math.max(high, matrix.get(i).get(matrix.get(i).size() - 1));
		}

		int totalNumbersOnEachSide = (matrix.size() * matrix.get(0).size()) / 2;
		while(low <= high)
		{
			int mid = low + ((high - low) / 2);
			int countOfSmallerNumbers = countSmallerThanMid(matrix, mid);

			if(countOfSmallerNumbers > totalNumbersOnEachSide) 
			high = mid - 1;

			else
			low = mid + 1;
		}

		return low;
	}

	public static int countSmallerThanMid(ArrayList<ArrayList<Integer>> matrix, int target)
	{
		int count = 0;
		for(ArrayList<Integer> list : matrix)
		{
			int low = 0, high = list.size() - 1;
			while(low <= high)
			{
				int mid = low + ((high - low) / 2);

				if(list.get(mid) > target)
				high = mid - 1;

				else
				low = mid + 1;
			}

			count += low;
		}

		return count;
	}
}
