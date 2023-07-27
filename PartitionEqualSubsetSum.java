// https://leetcode.com/problems/partition-equal-subset-sum/description/

//import java.util.Arrays;

public class PartitionEqualSubsetSum {

    // Memoization
    /* public boolean canPartition(int[] nums) {
        if(nums.length == 1)
        return false;

        int start = 0;
        int end = nums.length - 1;
        int sum = 0;

        while(start <= end)
        {
            if(start == end)
            sum += nums[start];

            else
            sum += nums[start] + nums[end];

            start++;
            end--;
        }

        if(sum%2 != 0)
        return false;

        sum /= 2;

        int dp[][] = new int[nums.length][sum + 1];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        return find(nums.length - 1, sum, nums, dp);
    } */

    /* public static boolean find(int n, int k, int[] arr, int[][] dp)
    {
        if(k == 0)
        return true;

        if(n == 0)
        return (arr[n] == k);

        if(dp[n][k] != -1)
        return dp[n][k] == 1 ? true : false;

        boolean pick = false;
        if(arr[n] <= k)
        pick = find(n - 1, k - arr[n], arr, dp);

        boolean notPick = find(n - 1, k, arr, dp);

        dp[n][k] = pick || notPick ? 1 : 0;
        return pick || notPick;
    } */

    //Tabulation
    /* public boolean canPartition(int[] nums){
        if(nums.length == 1)
        return false;

        int start = 0;
        int end = nums.length - 1;
        int sum = 0;

        while(start <= end)
        {
            if(start == end)
            sum += nums[start];

            else
            sum += nums[start] + nums[end];

            start++;
            end--;
        }

        if(sum%2 != 0)
        return false;

        sum /= 2;

        boolean dp[][] = new boolean[nums.length][sum + 1];

        for(int i = 0; i < nums.length; i++)
        dp[i][0] = true;

        if(nums[0] <= sum)
        dp[0][nums[0]] = true;

        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 1; j <= sum; j++)
            {
                boolean pick = false;
                if(nums[i] <= j)
                pick = dp[i - 1][j - nums[i]];
        
                boolean notPick = dp[i - 1][j];
        
                dp[i][j] = pick || notPick;
            }
        }

        return dp[nums.length - 1][sum];
    } */

    //Space Optimized
    public boolean canPartition(int[] nums){
        if(nums.length == 1)
        return false;

        int start = 0;
        int end = nums.length - 1;
        int sum = 0;

        while(start <= end)
        {
            if(start == end)
            sum += nums[start];

            else
            sum += nums[start] + nums[end];

            start++;
            end--;
        }

        if(sum%2 != 0)
        return false;

        sum /= 2;

        boolean prev[] = new boolean[sum + 1];

        prev[0] = true;

        if(nums[0] <= sum)
        prev[nums[0]] = true;

        for(int i = 1; i < nums.length; i++)
        {
            boolean temp[] = new boolean[prev.length];
            temp[0] = true;
            for(int j = 1; j <= sum; j++)
            {
                boolean pick = false;
                if(nums[i] <= j)
                pick = prev[j - nums[i]];
        
                boolean notPick = prev[j];
        
                temp[j] = pick || notPick;
            }
            prev = temp;
        }

        return prev[sum];
    }
}
