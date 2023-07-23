// https://leetcode.com/problems/maximum-product-subarray/description/

/*
 * Multiplication of the entire array would ideally be the largest but we need to avoid odd -1's and 0's as that will reduce the answer. Do a preffix multiplication and
 * suffix multiplication and track the max answer. If at any point answer gets zero then simply start the product from 1 again.
 */

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int prefMul = 1;
        int suffMul = 1;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++)
        {
            if(prefMul == 0) prefMul = 1;
            if(suffMul == 0) suffMul = 1;

            prefMul *= nums[i];
            suffMul *= nums[nums.length - i - 1];

            max = Math.max(max, Math.max(prefMul, suffMul));
        }

        return max;
    }
}
