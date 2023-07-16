public class MaximumPathSumBinaryTree {
    // between two leaves
    /* public static long findMaxSumPath(TreeNode root) {
		long[] max = new long[1];
        max[0] = -1;
        find(root, max);
        return max[0];
	}

	public static long find(TreeNode root, long[] max)
    {
        if(root == null)
        return -1;

        long left = find(root.left, max);
        long right = find(root.right, max);

		if(left != -1 && right != -1)
        max[0] = Math.max(max[0], left + right + root.data);

        return Math.max(root.data, root.data + Math.max(left, right)); // or return (left == -1 && right == -1) ? root.data : root.data + Math.max(left, right);
    } */

    //may or may not be between two leaves (Leetcode)
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        find(root, max);
        return max[0];
    }

    public int find(TreeNode root, int[] max)
    {
        if(root == null)
        return 0;

        int left = find(root.left, max);
        int right = find(root.right, max);

        max[0] = Math.max(max[0], left + right + root.data); // Find max of current max and left + right + root

        return (root.data + Math.max(left, right) >= 0) ? root.data + Math.max(left, right) : 0; // return max of root + left or root + right whichever is larger, if negative
        // then return 0;
    }


    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int data) { this.data = data; }
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
