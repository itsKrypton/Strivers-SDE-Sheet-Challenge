/*
 * Keep going left until the current value is bigger than X as we want smaller number, as soon as the current number is greater than or equal to the given number, mark
 * it as a potential answer and continue going right to find a bigger number closer to the X.
 */

public class FloorInBST {
    public static int floorInBST(TreeNode root, int X) {
        int floor = -1;

        while(root != null)
        {
            if(root.val <= X)
            {
                floor = root.val;
                root = root.right;
            }

            else
            root = root.left;
        }

        return floor;
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

