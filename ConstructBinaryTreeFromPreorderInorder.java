import java.util.HashMap;

/*
 * Root will always start from the first index of preorder array, we find it's index in the inorder array and pass it's left side and right side to next pass of the 
 * function. For the preorder array, the length of the left side of inorder are the number of nodes in preorder array that we need and rest of it for the right side.
 * Do a dry run to understand.
 */

public class ConstructBinaryTreeFromPreorderInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inMap = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++)
        inMap.put(inorder[i], i);

        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inMap)
    {
        if(preStart > preEnd || inStart > inEnd)
        return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inorderRootIdx = inMap.get(root.val);
        int leftNodes = inorderRootIdx - inStart;

        root.left = buildTree(preorder, preStart + 1, preStart + leftNodes, inorder, inStart, inorderRootIdx - 1, inMap);
        root.right = buildTree(preorder, preStart + leftNodes + 1, preEnd, inorder, inorderRootIdx + 1, inEnd, inMap);

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

