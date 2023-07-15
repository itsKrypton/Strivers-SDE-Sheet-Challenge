/*
 * We are basically finding the max height of left side + right side from every node. And while returning from recursion, we pass the longest height from the left
 * and right side of the current node.
 */

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        maxDepth(root, diameter);

        return diameter[0];
    }

    public int maxDepth(TreeNode root, int[] diameter) {
        if(root == null)
        return 0;

        int left = maxDepth(root.left, diameter);
        int right = maxDepth(root.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);

        return 1 + Math.max(left, right);
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
