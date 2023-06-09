// https://leetcode.com/problems/reverse-pairs/description/ and https://www.codingninjas.com/codestudio/problems/reverse-pairs_8230825?challengeSlug=striver-sde-challenge

/*
 * Similar to CountInversions but we need to do our calculations in a different part before the merging of two arrays.
 */

public class ReversePairs {
    public static int reversePairs(int[] nums) {
        return sort(nums, 0, nums.length);
    }

    public static int sort(int arr[], int start, int end)
    {
        if(end - start == 1)
        return 0;

        int count = 0;

        int mid = start + ((end - start) / 2);

        count += sort(arr, start, mid); // sort left side
        count += sort(arr, mid, end); // sort right side

        count += countPairs(arr, start, end, mid); // count pairs

        merge(arr, start, end, mid); // merge both

        return count;
    }

    public static int countPairs(int[] arr, int start, int end, int mid)
    {
        int i = start, j = mid;
        int count = 0;

        while(i < mid && j < end)
        {
            if(((double)(arr[i])/2) > arr[j]) j++;
            
            else
            {
                count += j - mid;
                i++;
            }
        }

        if(i < mid)
        count += (mid - i) * (j - mid);

        return count;
    }

    public static void merge(int[] arr, int start, int end, int mid)
    {
        int i = start, j = mid, k = 0;
        int mix[] = new int[end - start];

        while(i < mid && j < end)
        {
            if(arr[i] < arr[j])
            {
                mix[k] = arr[i];
                i++;
                k++;
            }

            else
            {
                mix[k] = arr[j];
                j++;
                k++;
            }
        }

        while(i < mid)
        {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while(j < end)
        {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for(i=0; i < mix.length; i++)
        arr[start + i] = mix[i];
    }
}
