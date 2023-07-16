import java.util.HashMap;

/*
 * Similar to Construct binary tree from preorder and inorder but here you need to make changes in the next call of root.right. Here the root will be the last element
 * of the postorder array because it's left right root. The elements remaining to the left will start from the left in postorder array and the rest of the elements
 * until the last element will be the part of right side of the tree.
 */

public class ConstructBinaryTreeFromPostorderInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++)
        inMap.put(inorder[i], i);

        TreeNode root = buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);

        return root;
    }

    public TreeNode buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inMap)
    {
        if(postStart > postEnd || inStart > inEnd)
        return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inorderRootIdx = inMap.get(root.val);
        int leftNodes = inorderRootIdx - inStart;

        root.left = buildTree(postorder, postStart, postStart + leftNodes - 1, inorder, inStart, inorderRootIdx - 1, inMap);
        root.right = buildTree(postorder, postStart + leftNodes, postEnd - 1, inorder, inorderRootIdx + 1, inEnd, inMap);

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
