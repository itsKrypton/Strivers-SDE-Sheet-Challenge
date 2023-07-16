import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagOrderBinaryTreeTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();

        if(root == null)
        return ans;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while(!queue.isEmpty())
        {
            LinkedList<Integer> subList = new LinkedList<>();
            int currentSize = queue.size();
            for(int i = 0; i < currentSize; i++)
            {
                if(queue.peek().left != null)
                queue.add(queue.peek().left);

                if(queue.peek().right != null)
                queue.add(queue.peek().right);

                if(leftToRight)
                subList.addLast(queue.remove().val);

                else
                subList.addFirst(queue.remove().val);
            }

            leftToRight = !leftToRight;
            ans.add(subList);
        }

        return ans;
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
