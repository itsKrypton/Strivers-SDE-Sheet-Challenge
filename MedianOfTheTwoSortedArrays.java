// https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/979062025/

// See https://takeuforward.org/data-structure/median-of-two-sorted-arrays-of-different-sizes/

public class MedianOfTheTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int numbersOnLeft = (nums1.length + nums2.length + 1) / 2;

        return (nums1.length <= nums2.length) ? helper(nums1, nums2, numbersOnLeft) : helper(nums2, nums1, numbersOnLeft);
    }
    
    public static double helper(int[] a, int[] b, int numbersOnLeft)
    {
        int low = 0, high = a.length;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;

            int left1 = (mid == 0) ? Integer.MIN_VALUE : a[mid - 1];
            int left2 = (numbersOnLeft - mid == 0) ? Integer.MIN_VALUE : b[numbersOnLeft - mid - 1];
            int right1 = (mid == a.length) ? Integer.MAX_VALUE : a[mid];
            int right2 = (numbersOnLeft - mid == b.length) ? Integer.MAX_VALUE : b[numbersOnLeft - mid];

            if(left1 > right2)
            high = mid - 1;

            else if(left2 > right1)
            low = mid + 1;

            else
            {
                if((a.length + b.length) % 2 == 0)
                return (((double)Math.max(left1, left2) + (double)Math.min(right1, right2)) / 2);
                
                return Math.max(left1, left2);
            } 
        }

        return -1;
    }
}
