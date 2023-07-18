/*
 * Taking advantage of the BST properties, we just need to find the node where p and q are not on the same side of the subtree of the current node. That node will be our
 * answer. 
 */

public class LCAOfABST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q)
        return root;

        if(p.val < root.val && q.val < root.val)
        return lowestCommonAncestor(root.left, p, q);

        else if(p.val > root.val && q.val > root.val)
        return lowestCommonAncestor(root.right, p, q);

        else
        return root;
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
