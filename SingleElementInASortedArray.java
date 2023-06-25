import java.util.ArrayList;

public class SingleElementInASortedArray {
    public static int singleNonDuplicate(ArrayList<Integer> arr)
    {
        int start = 0, end = arr.size() - 2;

        while(start <= end)
        {
            int mid = start + ((end - start) / 2);
            if(mid%2 == 0)
            {
                if(!arr.get(mid).equals(arr.get(mid + 1)))
                end = mid - 1;

                else 
                start = mid + 1;
            }

            else
            {
                if(arr.get(mid).equals(arr.get(mid + 1)))
                end = mid - 1;

                else 
                start = mid + 1;
            }
        }

        return arr.get(start);
    }
}
