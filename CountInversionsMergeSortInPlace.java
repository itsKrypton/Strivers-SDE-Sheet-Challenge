// Here we aren't using public variable as it's not advised to do so in interviews and this also using merge sort in place, otherwise the problem is same.

public class CountInversionsMergeSortInPlace {
    public static long getInversions(long arr[], int n) {
        return sort(arr, 0, n);
    }

    public static long sort(long arr[], int start, int end)
    {
        if(end - start == 1)
        return 0;

        long count = 0;

        int mid = (start + end) / 2;

        count += sort(arr, start, mid); // sort left side
        count += sort(arr, mid, end); // sort right side

        count += merge(arr, start, end, mid); // merge both

        return count;
    }

    public static long merge(long[] arr, int start, int end, int mid)
    {
        int i = start, j = mid, k = 0;
        long count = 0;

        long mix[] = new long[end - start];
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
                count += (mid - i);
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

        return count;
    }
}

