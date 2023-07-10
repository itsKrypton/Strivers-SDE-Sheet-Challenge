import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	List<Integer> ans = new ArrayList<>();
        find(root, ans);

        return ans;
    }

	public static void find(TreeNode root, List<Integer> ans)
    {
        TreeNode current = root;
        while(current != null)
        {
            if(current.left == null)
            {
                ans.add(current.data);
                current = current.right;
            }

            else
            {
                TreeNode prev = current.left;
                while(prev.right != null && prev.right != current)
                prev = prev.right;

                if(prev.right == null)
                {
                    prev.right = current;
                    ans.add(current.data);
                    current = current.left;
                }

                else
                {
                    prev.right = null;
                    current = current.right;
                }
            }
        }

        return;
    }

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.data = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
        }
    }
}
