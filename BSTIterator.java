import java.util.Stack;

// https://leetcode.com/problems/binary-search-tree-iterator/description/

/*
 * Here we are doing a stack traversal of the BST. First we insert all the nodes to the left starting at root. Whenever we pop a node we check if it has right node and
 * add all the left nodes to it. We keep doing that until the stack is empty.
 * 
 * T: O(1) amortized. At max N passes will be done for n calls, n/n = 1.
 * S: O(h) at max we will be storing height number of nodes.
 */

public class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftNodes(root);
    }

    public int next() {
        TreeNode current = stack.pop();
        pushLeftNodes(current.right);
        return current.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeftNodes(TreeNode root)
    {
        for(; root != null; stack.push(root), root = root.left);
        /*
         * This above code is same as 
         * while(root != null)
         * {
         *      stack.push(root);
         *      root = root.left;
         * }
         */
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
