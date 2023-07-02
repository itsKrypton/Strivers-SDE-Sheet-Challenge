/*
 * Remove all the elements one by one and start adding all again using insertion sort, basically adding that element into it's right position. That is, we keep popping
 * the elements till we find the right place for the current element, then we insert the popped elements again.
 */

import java.util.Stack;

public class SortAStack {
    public static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty()) return;

		int element = stack.pop();
		sortStack(stack);
		insertAtCorrectPosition(element, stack);
	}

	public static void insertAtCorrectPosition(int element, Stack<Integer> stack)
	{
		if(stack.isEmpty() || stack.peek() <= element)
		{
			stack.push(element);
			return;
		}

		int x = stack.pop();
		insertAtCorrectPosition(element, stack);
		stack.push(x);
	} 
}
