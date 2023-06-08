import java.util.ArrayList;

public class SearchInA2DMatrix {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int sRow = 0;
        int eRow = mat.size() - 1;

        while(sRow <= eRow)
        {
            int mid = sRow + (eRow - sRow) / 2;

            if(mat.get(mid).get(0) <= target && mat.get(mid).get(mat.get(mid).size() - 1) >= target)
            return binarySearch(mat.get(mid), 0, mat.get(mid).size() - 1, target);

            else if(mat.get(mid).get(mat.get(mid).size() - 1) < target)
            sRow = mid + 1;

            else 
            eRow = mid - 1;
        }

        return false;
    }

    public static boolean binarySearch(ArrayList<Integer> row, int start, int end, int target)
    {
        while(start <= end)
        {
            int mid = start + (end - start) / 2;
            if(row.get(mid) == target)
            return true;

            else if(row.get(mid) > target)
            end = mid - 1;

            else
            start = mid + 1;
        }

        return false;
    }
}
