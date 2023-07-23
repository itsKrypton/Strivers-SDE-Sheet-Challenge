import java.util.ArrayList;

// https://leetcode.com/problems/longest-increasing-subsequence/description/

//import java.util.Arrays;

/*
 * DP take or not take approach, store the prevIndex of last chosen number and for every take check if that number is greater then prevIndex number, if yes then 
 * current number will be new prevIndex. Else continue with not taking current number.
 */

public class LongestIncreasingSubsequence {
    // Memoization
    /* public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];

        for(int i[] : dp)
        Arrays.fill(i, -1);

        return find(0, -1, nums, dp);
    }

    public static int find(int n, int prevIndex, int[] nums, int[][] dp)
    {
        if(n == nums.length)
        return 0;

        if(dp[n][prevIndex + 1] != -1)
        return dp[n][prevIndex + 1];

        int take = Integer.MIN_VALUE;
        if(prevIndex == -1 || nums[n] > nums[prevIndex])
        take = 1 + find(n + 1, n, nums, dp);

        int notTake = find(n + 1, prevIndex, nums, dp);

        return dp[n][prevIndex + 1] = Math.max(take, notTake);
    } */

    // Tabulation
    /* public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];

        for(int i = nums.length - 1; i >= 0; i--)
        {
            for(int j = i - 1; j >= -1; j--)
            {
                int take = Integer.MIN_VALUE;
                if(j == -1 || nums[i] > nums[j])
                take = 1 + dp[i + 1][i + 1];
        
                int notTake = dp[i + 1][j + 1];
        
                dp[i][j + 1] = Math.max(take, notTake); 
            }
        }

        return dp[0][0];
    } */

    //Space Optimization Even this gives time complexity of n^2 which is too much, right approach is via binary search.
    /* public int lengthOfLIS(int[] nums) {
        int[] next = new int[nums.length + 1];

        for(int i = nums.length - 1; i >= 0; i--)
        {
            int temp[] = new int[next.length];
            for(int j = i - 1; j >= -1; j--)
            {
                int take = Integer.MIN_VALUE;
                if(j == -1 || nums[i] > nums[j])
                take = 1 + next[i + 1];
        
                int notTake = next[j + 1];
        
                temp[j + 1] = Math.max(take, notTake); 
            }
            next = temp;
        }

        return next[0];
    } */

    // Another Tabulated approach, this one is useful to print the LIS T: O(n^2) S: O(n)
    /* public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int max = 1;

        for(int i = 0; i < nums.length; i++)
        {
            for(int prev = 0; prev < i; prev++)
            {
                if(nums[prev] < nums[i])
                dp[i] = Math.max(dp[i], 1 + dp[prev]);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    } */

    // To print LIS use another array to store the indexes of answers
    /* public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] hash = new int[nums.length];

        Arrays.fill(dp, 1);

        int max = 1;
        int lastIndex = 0;

        for(int i = 0; i < nums.length; i++)
        {
            hash[i] = i;
            for(int prev = 0; prev < i; prev++)
            {
                if(nums[prev] < nums[i] && (1 + dp[prev] > dp[i]))
                {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if(dp[i] > max)
            {
                max = dp[i];
                lastIndex = i;
            }
        }

        int i = max - 1;
        int[] answer = new int[max];
        answer[i--] = nums[lastIndex];

        while(hash[lastIndex] != lastIndex)
        {
            lastIndex = hash[lastIndex];
            answer[i--] = nums[lastIndex];
        }

        for(int ind : answer)
        System.out.print(ind + " ");

        return max;
    } */

    //Best approach (Binary Search) T: O(nlogn) S: O(n)

    /*
     * We basically keep on adding the bigger numbers in arraylist, if a smaller number comes in then using BS, we search at which index can we place that new number.
     * At the end, the length of arraylist will be our answer.
     */

    public static void main(String args[])
    {
        int nums[] = new int[]{0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums)); 
    }
    public static int lengthOfLIS(int[] nums) {
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);

        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > lis.get(lis.size() - 1))
            lis.add(nums[i]);

            else
            {
                int index = binarySearch(nums[i], lis);
                lis.set(index, nums[i]);
            }
        }

        return lis.size();
    }

    public static int binarySearch(int target, ArrayList<Integer> lis)
    {
        int start = 0;
        int end = lis.size() - 1;

        while(start <= end)
        {
            int mid = start + ((end - start) / 2);

            if(lis.get(mid) < target)
            start = mid + 1;

            else if(lis.get(mid) > target)
            end = mid - 1;

            else
            return mid;
        }

        return start;
    }
}