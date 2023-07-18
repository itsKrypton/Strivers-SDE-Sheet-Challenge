// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

/*
 * Have a max value for every node you insert. For first node it would be Integer.MAX_VALUE and for every left node it will be the previous nodes value. For the right
 * node the bound value will be the same as before.
 */

 public class ConstructBSTFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        return find(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    public TreeNode find(int[] preorder, int upperBound, int[] index)
    {
        if(index[0] == preorder.length || preorder[index[0]] >= upperBound)
        return null;

        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = find(preorder, root.val, index);
        root.right = find(preorder, upperBound, index);

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
