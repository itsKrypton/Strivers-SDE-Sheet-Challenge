import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        find(root, ans);

        return ans;
    }

    public static void find(TreeNode root, List<Integer> ans)
    {
        if(root == null)
        return;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while(!stack1.isEmpty())
        {
            TreeNode currentNode = stack1.pop();
            stack2.push(currentNode); 

            if(currentNode.left != null)
            stack1.push(currentNode.left);

            if(currentNode.right != null)
            stack1.push(currentNode.right);
        }

        while(!stack2.isEmpty())
        ans.add(stack2.pop().val);

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

