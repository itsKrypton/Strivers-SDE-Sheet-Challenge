/*
 * Morris traversal inorder
 */

public class ConvertBinaryTreeToDLL {
    public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
		BinaryTreeNode<Integer> head = null;
		BinaryTreeNode<Integer> prev = null;

		while(root != null)
		{
            // Go to the rightmost node of the current.left
			if(root.left != null)
			{
				BinaryTreeNode<Integer> next = root.left;

				while(next.right != null && next.right != root)
				next = next.right;

                // We have already traversed left side so connect current to prev but not prev to current as this may not be the leftmost node. Take current to current.right
				if(next.right == root)
				{
					root.left = prev;
					prev = root;
					root = root.right;
				}

                // We haven't traversed the left so connect next.right to current and move left.
				else
				{
					next.right = root;
					root = root.left;
				}
			}

            // We have reached the left most side so we connect current to prev and prev to current. Prev is then current and current is current.right
			else
			{
				if(head == null)
				head = root;

				root.left = prev;

				if(prev != null)
				prev.right = root;

				prev = root;
				root = root.right;
			}
		}

		return head;
	}

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
        BinaryTreeNode() {}
    }
}
