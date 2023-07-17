/*
 * As the input is sorted, we don't need to perform any rotations to balance the tree. We know that the middle number in the input will be our root as only then the
 * left and right side would have nearly equal number of nodes. So do the same recursively on left and right side as well to find their respective middle nodes and 
 * at the end, the output will be a height balanced tree.
 */

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length - 1, nums);
    }

    public TreeNode helper(int low, int high, int[] nums)
    {
        if(low > high) 
        return null;

        if(low == high) 
        return new TreeNode(nums[low]);

        int mid = low + (high - low) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(low, mid - 1, nums);
        root.right = helper(mid + 1, high, nums);

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
