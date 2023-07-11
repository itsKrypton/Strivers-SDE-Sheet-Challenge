// https://www.codingninjas.com/studio/problems/981269?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

/*
 * Add the root node having "pre" order tag in a stack. For every current stack, if order is "pre", add it to pre list, increment it to "in" and if left exists then add it
 * with "pre" order. Else if it's "In", add to "In" list and increment order to "Post" and if right exists then add it to stack. Else if it's "Post" then add to post
 * list and remove the Pair from stack.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversals {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> ans = new ArrayList<>();

		if(root == null)
		return ans;

		for(int i = 0; i < 3; i++)
		ans.add(new ArrayList<>());

		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(root, "Pre"));

		while(!stack.isEmpty())
		{
			Pair curr = stack.peek();

			if(curr.order.equals("Pre"))
			{
				ans.get(1).add(curr.node.data);
				curr.order = "In";

				if(curr.node.left != null)
				stack.push(new Pair(curr.node.left, "Pre"));
			}

			else if(curr.order.equals("In"))
			{
				ans.get(0).add(curr.node.data);
				curr.order = "Post";

				if(curr.node.right != null)
				stack.push(new Pair(curr.node.right, "Pre"));
			}

			else if(curr.order.equals("Post"))
			{
				ans.get(2).add(curr.node.data);
				stack.pop();
			}
		}

		return ans;
    }

	public static class Pair {
		private BinaryTreeNode<Integer> node;
		private String order;

		public Pair(BinaryTreeNode<Integer> node, String order)
		{
			this.node = node;
			this.order = order;
		}
	}

    public class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
        BinaryTreeNode() {}
        BinaryTreeNode(T data) { this.data = data; }
    }
}
