// https://www.codingninjas.com/codestudio/problems/largest-bst-subtree_893103?leftPanelTab=1

/*
 * We do a post order traversal as we need the left and right nodes first. For every node we check if the max value of left side is smaller than current nodes value and
 * the min value of right side is bigger than the current nodes value, if it is then it's a BST. In that case, we increase the size value and pass new min and max values
 * to above nodes. If it's not a BST, we pass the max size of left and right size and we pass such min and max values that it won't be accepted as a BST for 
 * upper nodes.
 */

 public class SizeOfLargestBSTInBinaryTree {
    public static int largestBST(TreeNode root) {
		return largestBSThelper(root).size;
	}

    public static NodeValue largestBSThelper(TreeNode root)
    {
        if(root == null)
        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        NodeValue left = largestBSThelper(root.left);
        NodeValue right = largestBSThelper(root.right);

        if(root.val > left.maxValue && root.val < right.minValue)
        return new NodeValue(Math.min(root.val, left.minValue), Math.max(root.val, right.maxValue), 1 + left.size + right.size);

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }

    public static class NodeValue 
    {
        int minValue;
        int maxValue;
        int size;

        NodeValue(int minValue, int maxValue, int size)
        {
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.size = size;
        }
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

    // If the max sum of nodes is asked.

    /* public int maxSumBST(TreeNode root) {
        int max[] = new int[1];
        largestBSThelper(root, max);

        return max[0];
    }
    
    public NodeValue largestBSThelper(TreeNode root, int[] max) {
        if(root == null)
        return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        NodeValue left = largestBSThelper(root.left, max);
        NodeValue right = largestBSThelper(root.right, max);

        if(root.val > left.maxValue && root.val < right.minValue)
        {
            max[0] = Math.max(max[0], root.val + left.size + right.size);
            return new NodeValue(Math.min(root.val, left.minValue), Math.max(root.val, right.maxValue), root.val + left.size + right.size);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
    }

    public class NodeValue 
    {
        private int minValue;
        private int maxValue;
        private int size;

        NodeValue(int minValue, int maxValue, int size)
        {
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.size = size;
        }
    } */
}
