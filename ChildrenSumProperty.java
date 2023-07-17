// https://www.codingninjas.com/codestudio/problems/childrensumproperty_790723?leftPanelTab=0

public class ChildrenSumProperty {
    /*
     * Traverse through the tree and keep a max variable to store max till now, if root's value is lower than max then change it's value to max. While coming back up
     * add both child nodes and parents value to the total. 
     * 
     * This approach is different than Strivers.
     */

    public static void changeTree(BinaryTreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        find(root, max);
    }

    public static void find(BinaryTreeNode root, int[] max)
    {
        if(root == null)
        return;

        max[0] = Math.max(max[0], root.val);
        if(root.val < max[0]);
        root.val = max[0];

        find(root.left, max);
        find(root.right, max);

        int total = 0;
        if(root.left != null)
        total += root.left.val;

        if(root.right != null)
        total += root.right.val;

        if(root.left == null && root.right == null)
        return;

        else
        {
            root.val = total;
            return;
        }
    }

    public class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode() {}
        BinaryTreeNode(int val) { this.val = val; }
        BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

