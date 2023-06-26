/*
 * Similar to MedianOfTheTwoSortedArrays, difference being that the total numbers on the left hand side is basically k. We just need to divide the array such that left
 * side has k elements and right has the remaining elements.
 */

public class KthElementOfTwoSortedArrays {
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
        /* if(row1.length > row2.length) return ninjaAndLadoos(row2, row1, n, m, k);

        int low = 0, high = row1.length;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            if(mid > k)
            {
                high = k;
                continue;
            }

            else if(mid + row2.length < k)
            {
                low = mid + 1;
                continue;
            }

            int left1 = (mid == 0) ? Integer.MIN_VALUE : row1[mid - 1];
            int left2 = (k - mid == 0) ? Integer.MIN_VALUE : row2[k - mid - 1];
            int right1 = (mid == row1.length) ? Integer.MAX_VALUE : row1[mid];
            int right2 = (k - mid == row2.length) ? Integer.MAX_VALUE : row2[k - mid];

            if(left1 > right2)
            high = mid - 1;

            else if(left2 > right1)
            low = mid + 1;

            else
            return Math.max(left1, left2);
        }

        return -1; */

        // or 

        if(row1.length > row2.length) return ninjaAndLadoos(row2, row1, n, m, k);

        int low = Math.max(0, k - row2.length), high = Math.min(k, row1.length);

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            int left1 = (mid == 0) ? Integer.MIN_VALUE : row1[mid - 1];
            int left2 = (k - mid == 0) ? Integer.MIN_VALUE : row2[k - mid - 1];
            int right1 = (mid == row1.length) ? Integer.MAX_VALUE : row1[mid];
            int right2 = (k - mid == row2.length) ? Integer.MAX_VALUE : row2[k - mid];

            if(left1 > right2)
            high = mid - 1;

            else if(left2 > right1)
            low = mid + 1;

            else
            return Math.max(left1, left2);
        }

        return -1;
    }
}
