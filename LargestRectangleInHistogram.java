/*
 * Keep adding elements to the stack if the number is greater than st.peek(), if it's not, the current element is the right border for all the elements it is smaller
 * than in the stack and the left border for the current stack element would be the element just below it.
 */

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangle(ArrayList < Integer > heights) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
    
        for(int i = 0; i <= heights.size(); i++)
        {
            while(!st.isEmpty() && (i == heights.size() || heights.get(st.peek()) >= heights.get(i)))
            {
                int height = heights.get(st.pop());
                int width = 0;
    
                if(st.isEmpty())
                width = i;
    
                else
                width = i - st.peek() - 1;
    
                max = Math.max(max, width * height);
            }
            st.push(i);
        }
    
        return max;
      }
}
