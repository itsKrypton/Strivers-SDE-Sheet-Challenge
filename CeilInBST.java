/*
 * Keep going right until the current value is less than X as we want bigger number, as soon as the current number is less than or equal to the given number, mark
 * it as a potential answer and continue going left to find a smaller number closer to the X.
 */

public class CeilInBST {
    public  static int findCeil(TreeNode<Integer> node, int x) {
        int ceil = -1;

        while(node != null)
        {
            if(node.val >= x)
            {
                ceil = node.val;
                node = node.left;
            }

            else
            node = node.right;
        }

        return ceil;
    }

    public class TreeNode<T> {
        T val;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode() {}
    }
}

