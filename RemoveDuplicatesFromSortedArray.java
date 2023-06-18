import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		int curr = 0, i = 0;
        while(i < n)
        {
            arr.set(curr++, arr.get(i));

            while(i < n - 1 && arr.get(i).equals(arr.get(i + 1))) i++;
            i++;
        }

        return curr;
	}
}
