// https://leetcode.com/problems/sliding-window-maximum/description/

/*
 * We get a deque and add indexes of elements in decreasing fashion. Anytime our first element in queue is less than the window size then we remove that element. Also,
 * when inserting new element to deque, we remove all elements on the right that are lesser than the current element, only then we insert the current element.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] answer = new int[nums.length - k + 1];

        for(int i = 0; i < nums.length; i++)
        {
            if(!deque.isEmpty() && deque.peekFirst() == i - k)
            deque.removeFirst();

            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
            deque.removeLast();

            deque.add(i);

            if(i >= k - 1)
            answer[i - k + 1] = nums[deque.peekFirst()];
        }

        return answer;
    }
}
