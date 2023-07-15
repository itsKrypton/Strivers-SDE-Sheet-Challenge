import java.util.LinkedList;
// https://leetcode.com/problems/binary-tree-level-order-traversal/submissions/851650221/

/*
 * If the root is not null, add it to the queue, next store the left and right nodes of it and add the current nodes value to the list. Do this for the size of current
 * queue and do it again for the next set of nodes until the queue is empty.
 * T: O(n) S: O(n)
 */

import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> myList = new LinkedList<>();
        Queue<TreeNode> myQueue = new LinkedList<>();
        
        if(root == null)
        return myList;

        myQueue.add(root);
        while(!myQueue.isEmpty())
        {
            int size = myQueue.size();
            List<Integer> subList = new LinkedList<>();
    
            for(int i = 0; i < size; i++)
            {
                if(myQueue.peek().left != null)
                myQueue.add(myQueue.peek().left);
    
                if(myQueue.peek().right != null)
                myQueue.add(myQueue.peek().right);
    
                subList.add(myQueue.remove().val);
            }
            myList.add(subList);
        }

        return myList;
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

