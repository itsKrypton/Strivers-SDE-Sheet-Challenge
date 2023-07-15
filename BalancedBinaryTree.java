// Simlar concept as DiameterOfBinaryTree, find the left height and right height at a node, if the absolute difference is greater than 1 then return false else return
// the larger height to the previous function call.

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return (maxDepth(root) == -1) ? false : true;
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
        return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if(Math.abs(left - right) > 1 || left == -1 || right == -1)
        return -1;

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
