import java.util.LinkedList;
import java.util.Queue;

/*
 * The idea is to index all the nodes and then subtract the max index at a level with the min index to find the width of the tree. However, normal indexing increases
 * exponentially and will give overflow for large number of nodes. Thus for every level we start the indexing again from the current index - minimum index. Thus for a
 * complete binary tree, the indexing will always start from 1.
 */
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        int maxWidth = Integer.MIN_VALUE;
        while(!queue.isEmpty())
        {
            int currentSize = queue.size();
            int minIndex = queue.peek().index;
            int first = 0, last = 0;

            for(int i = 0; i < currentSize; i++)
            {
                Pair current = queue.poll();

                if(i == 0)
                first = current.index;

                if(i == currentSize - 1)
                last = current.index;

                if(current.node.left != null)
                queue.add(new Pair(current.node.left, 2 * (current.index - minIndex) + 1));

                if(current.node.right != null)
                queue.add(new Pair(current.node.right, 2 * (current.index - minIndex) + 2));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }

    public class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node, int index)
        {
            this.node = node;
            this.index = index;
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
}

