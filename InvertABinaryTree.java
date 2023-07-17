/*
 * Take a stack and fill it with the path to the given leaf node. Now traverse fromm the top to bottom of the stack and make the changes to left and right links
 * as given in the problem.
 */

import java.util.Stack;

public class InvertABinaryTree {
    public static TreeNode<Integer> invertBinaryTree(TreeNode<Integer> root, TreeNode<Integer> leaf) {
        Stack<TreeNode<Integer>> stack = new Stack<>();
        findPath(root, leaf, stack);

        TreeNode<Integer> newRoot = stack.peek();
        TreeNode<Integer> parent = stack.pop();
        
        while(!stack.isEmpty())
        {
            TreeNode<Integer> current = stack.pop();

            parent.left = current;

            if(current.left != parent)
            current.right = current.left;

            current.left = null;
            parent = current;
        }

        return newRoot;
    }

    public static boolean findPath(TreeNode<Integer> root, TreeNode<Integer> leaf, Stack<TreeNode<Integer>> stack)
    {
        if(root == null)
        return false;

        stack.push(root);

        if(root.data.equals(leaf.data))
        return true;

        if(findPath(root.left, leaf, stack)) return true;
        if(findPath(root.right, leaf, stack)) return true;

        stack.pop();
        return false;
    }

    public class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode() {}
        TreeNode(T data) { this.data = data; }
        TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
