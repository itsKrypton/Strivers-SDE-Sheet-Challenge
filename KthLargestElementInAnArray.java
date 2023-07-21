// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

// Can apparantly be done in O(n) average time using Quick Select Algo, need to learn.

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++)
        {
            if(pQueue.size() < k)
            pQueue.add(nums[i]);

            else if(nums[i] > pQueue.peek())
            {
                pQueue.remove();
                pQueue.add(nums[i]);
            }
        }

        return pQueue.peek();
    }
}
