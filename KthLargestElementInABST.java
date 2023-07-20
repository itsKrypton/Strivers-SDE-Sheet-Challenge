/*
 * Opposite of KthSmallestElementInABST, just do reverse inorder for largest element first.
 */

public class KthLargestElementInABST {
    public static int KthLargestNumber(TreeNode<Integer> root, int k) {
		int[] temp = new int[1];
        temp[0] = k;

        return find(root, temp);
	}

	public static int find(TreeNode<Integer> root, int[] k)
    {
        if(root == null)
        return -1;

        int right = find(root.right, k);
        if(right != -1) return right;

        k[0]--;
        if(k[0] == 0)
        return root.data;

        return find(root.left, k);
    }

    public class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode() {}
    }
}
