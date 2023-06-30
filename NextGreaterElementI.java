// https://leetcode.com/problems/next-greater-element-i/description/

/*
 * Use stack, push into stack till the number is smaller than previous, if it's big than pop until a smaller is found.
 */

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i = nums2.length - 1; i >= 0; i--)
        {
            if(!stack.isEmpty())
            {
                if(nums2[i] > stack.peek())
                {
                    while(!stack.isEmpty() && nums2[i] > stack.peek())
                    stack.pop();
                }

                if(!stack.isEmpty())
                map.put(nums2[i], stack.peek());

                else
                map.put(nums2[i], -1);
            }

            else
            map.put(nums2[i], -1);

            stack.push(nums2[i]);
        }

        int[] answer = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++)
        answer[i] = map.get(nums1[i]);

        return answer;
    }
}
