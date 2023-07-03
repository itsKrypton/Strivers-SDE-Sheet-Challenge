/*
 * Using the concept of LargestRectangleInHistogram, find the left smallest and right smallest index of a number and get the range. The current number might be the biggest
 * number for the current window range. Once all the ranges possible are found, run loop from end and check for the maximum number between the current number and max number,
 * that will be the answer.
 */

import java.util.Arrays;
import java.util.Stack;

public class MaximumOfMinimumOfEveryWindowSize {
    public static int[] maxMinWindow(int[] a, int n) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MIN_VALUE);

        for(int i = 0; i <= n; i++)
        {
            while(!st.isEmpty() && (i == n || a[st.peek()] >= a[i]))
            {
                int top = a[st.pop()];
                int range = 0;
    
                if(st.isEmpty())
                range = i - 1;
    
                else
                range = i - st.peek() - 2;
    
                ans[range] = Math.max(ans[range], top);
            }
            st.push(i);
        }

        int max = ans[n - 1];

        for(int i = n - 1; i >= 0; i--)
        {
            max = Math.max(max, ans[i]);
            ans[i] = max;
        }

        return ans;
    }
}
