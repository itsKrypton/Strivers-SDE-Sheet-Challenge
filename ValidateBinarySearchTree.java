// https://leetcode.com/problems/validate-binary-search-tree/description/

/*
 * Use inorder as we know that the inorder of a BST has the node values in sorted order. If at any point you find that the current root value is less than last root
 * value then return false as in a valid BST, the inorder is sorted.
 */

 public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        long lastValue[] = new long[1];
        lastValue[0] = Long.MIN_VALUE;

        return find(root, lastValue);
    }

    public boolean find(TreeNode root, long[] lastValue)
    {
        if(root == null)
        return true;

        boolean left = find(root.left, lastValue);
        if(!left) return false;

        if(root.val <= lastValue[0])
        return false;
        lastValue[0] = root.val;

        return find(root.right, lastValue);
    }

    // Another approach is to use min value and max value for every node. Same time complexity O(n)

    /* public boolean isValidBST(TreeNode root) {
        return find(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean find(TreeNode root, long minValue, long maxValue)
    {
        if(root == null)
        return true;

        if(root.val >= maxValue || root.val <= minValue)
        return false;

        return find(root.left, minValue, root.val) && find(root.right, root.val, maxValue);
    } */

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
