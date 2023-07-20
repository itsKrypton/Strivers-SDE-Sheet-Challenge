// https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/

/*
 * Use the BST Iterator method with smallest and largest element.
 */

import java.util.Stack;

public class TwoSumIVBST {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);
 
        int l = left.next();
        int r = right.next();

        while(l < r)
        {
            if(l + r == k)
            return true;

            else if(l + r < k)
            l = left.next();

            else
            r = right.next();
        }
 
        return false;
    }
}
 
class BSTIterator
{
    private Stack<TreeNode> stack;
    private boolean isReverse;

    public BSTIterator(TreeNode root, boolean reverse) {
        stack = new Stack<>();
        isReverse = reverse;
        pushNodes(root);
    }

    public int next() {
        TreeNode current = stack.pop();

        if(isReverse)
        pushNodes(current.left);

        else
        pushNodes(current.right);

        return current.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushNodes(TreeNode root)
    {
        while(root != null)
        {
            stack.push(root);
            root = (isReverse) ? root.right : root.left;
        }
    }
}
 
class TreeNode {
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
 
