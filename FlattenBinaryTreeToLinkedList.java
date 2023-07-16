// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

// Do a dry run to understand, it uses Morris traversal as done in the Binary Tree Preorder traversal with some changes.

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while(current != null)
        {
            if(current.left != null) 
            {
                TreeNode prev = current.left;
                while(prev.right != null && prev.right != current)
                prev = prev.right;

                prev.right = current.right;
                current.right = current.left;
                current.left = null;
            }

            current = current.right;
        }
    }

    // Recursive solution, we basically go in the opposite direction here i.e right, left and then root.
    /* TreeNode prev = null;
    public void flatten(TreeNode root)
    {
        if(root == null)
        return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;
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
