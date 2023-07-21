/*
 * Maintain a minHeap to store the K largest numbers and everytime when a number appears which is larger than the smallest element of k largest elements then remove
 * the smallest element and insert the new number;
 * 
 * T: O(log k) to add elements.um
 */

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for(int num : nums)
        add(num);
    }
    
    public int add(int val) {
        if(this.minHeap.size() < this.k)
        minHeap.add(val);

        else if(val > this.minHeap.peek())
        {
            minHeap.remove();
            minHeap.add(val);
        }

        return minHeap.peek();
    }
}
