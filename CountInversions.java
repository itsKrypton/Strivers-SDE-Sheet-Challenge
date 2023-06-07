// https://www.codingninjas.com/codestudio/problems/count-inversions_8230680?challengeSlug=striver-sde-challenge&leftPanelTab=0

/*
 * We perform the usual merge sort algorithm but while merging, whenever the left side value is bigger than the value on the right side, we add all the number of elements
 * to the right of the current element in the left array to the count variable as all the values to the right will also be bigger than the current value in the 
 * right array. Thus the count variable will be a global variable to keep track of the pairs of elements where the left value is greater than the right element in all
 * merge function calls.
 */

import java.util.Arrays;

public class CountInversions {
    public static long count = 0;

    public static long getInversions(long arr[], int n) {
        sort(arr);

        return count;
    }

    public static long[] sort(long arr[])
    {
        if(arr.length == 1)
        return arr; // to return the individual elements

        int mid = arr.length / 2;

        long left[] = sort(Arrays.copyOfRange(arr, 0, mid)); // sort left side
        long right[] = sort(Arrays.copyOfRange(arr, mid, arr.length)); // sort right side

        return merge(left, right); // merge both
    }

    public static long[] merge(long[] left, long[] right)
    {
        int i = 0, j = 0, k = 0;

        long mix[] = new long[left.length + right.length];
        while(i < left.length && j < right.length)
        {
            if(left[i] < right[j])
            {
                mix[k] = left[i];
                i++;
                k++;
            }

            else
            {
                mix[k] = right[j];
                j++;
                k++;
                count += left.length - i;
            }
        }

        while(i < left.length)
        {
            mix[k] = left[i];
            i++;
            k++;
        }

        while(j < right.length)
        {
            mix[k] = right[j];
            j++;
            k++;
        }

        return mix;
    }
}
