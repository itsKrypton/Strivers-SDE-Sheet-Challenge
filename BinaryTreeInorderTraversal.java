import java.util.LinkedList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
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
                ans.add(current.val);
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
                    current = current.left;
                }

                else
                {
                    prev.right = null;
                    ans.add(current.val);
                    current = current.right;
                }
            }
        }

        return;
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
