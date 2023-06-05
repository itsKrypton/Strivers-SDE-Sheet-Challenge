public class MaximumSubarraySum {
    public static long maxSubarraySum(int[] arr, int n) {
		long local_max = 0;
        long global_max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {
            if(local_max < 0)
            local_max = arr[i];

            else
            local_max+=arr[i];

            global_max = Math.max(global_max, local_max);
        }
        return (global_max < 0) ? 0 : global_max;
	}
}
