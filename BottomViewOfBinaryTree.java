// https://www.codingninjas.com/codestudio/problems/bottom-view-of-binary-tree_893110

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/*
 * Same as the top view problem just remove the condition where you check whether the col already exists or not. As we are going left to right and top to bottom
 * the same column value will be replaced by the next value.
 */
public class BottomViewOfBinaryTree {
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        queue.add(new Pair(root, 0));

        while(!queue.isEmpty())
        {
            int currentSize = queue.size();
            while(currentSize-- > 0)
            {
                Pair current = queue.poll();
            
                map.put(current.col, current.node.val);
    
                if(current.node.left != null)
                queue.add(new Pair(current.node.left, current.col - 1));
    
                if(current.node.right != null)
                queue.add(new Pair(current.node.right, current.col + 1));
            }
        }

        for(int value : map.values())
        ans.add(value);

        return ans;
    }

    public static class Pair {
        BinaryTreeNode node;
        int col;

        Pair(BinaryTreeNode node, int col)
        {
            this.node = node;
            this.col = col;
        }
    }

    public class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode() {}
        BinaryTreeNode(int val) { this.val = val; }
        BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

