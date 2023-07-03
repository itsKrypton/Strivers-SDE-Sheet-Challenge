// https://leetcode.com/problems/min-stack/description/

import java.util.Stack;

public class MinStack {

    //T: O(1) S: O(n)
    Stack<Long> stack;
    Long min;

    public MinStack() {
        stack = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        Long value = Long.valueOf(val);

        if(stack.isEmpty())
        {
            this.min = value;
            this.stack.push(value);
        }

        else
        {
            if(value < this.min)
            {
                stack.push(2 * value - this.min);
                this.min = value;
            }

            else
            this.stack.push(value);
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;

        Long val = stack.pop();
        if(val < this.min)
        this.min = 2 * this.min - val;
    }
    
    public int top() {
        Long val = this.stack.peek();

        if (val < this.min) 
        return this.min.intValue();

        return val.intValue();
    }
    
    public int getMin() {
        return this.min.intValue();
    }

    //T: O(1) S: O(2n)
    /* Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int min = 0;
        if(stack.isEmpty())
        min = val;

        else
        min = Math.min(this.stack.peek().min, val);

        stack.push(new Pair(val, min));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
        return stack.peek().min;
    }

    public class Pair {
        private int value;
        private int min;

        public Pair (int value, int min) {
            this.value = value;
            this.min = min;
        }
    } */
}
