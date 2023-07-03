// https://leetcode.com/problems/online-stock-span/submissions/

/*
 * Maintain a stack of value and indexes (count) of numbers. Add the pairs in decreasing fashion so that for every incoming price, you will find the index which was
 * previously greater than the current price. The answer then would simply be current index - greater elements index. If the stack is empty, that means the current
 * element is greater than all the previous elements, thus, answer would be the current count itself.
 */

import java.util.Stack;

public class OnlineStockSpan {
    Stack<Pair> stack;
    int count;

    public OnlineStockSpan() {
        stack = new Stack<>();
        count = 0;
    }
    
    public int next(int price) {
        this.count++;

        while(!this.stack.isEmpty() && price >= this.stack.peek().value)
        this.stack.pop();

        int span = (!this.stack.isEmpty()) ? count - stack.peek().count : count;
        this.stack.push(new Pair(count, price));

        return span;
    }

    public class Pair {
        private int count;
        private int value;

        public Pair(int count, int value)
        {
            this.count = count;
            this.value = value;
        }
    }
}
