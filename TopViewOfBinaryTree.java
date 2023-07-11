//https://www.codingninjas.com/codestudio/problems/top-view-of-the-tree_799401?leftPanelTab=0

/*
 * See a tree column wise, we only add the nodes which come for the first time in a particular column. Root will have the col 0, and nodes to the left will be curr - 1,
 * and on right will be curr + 1.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {
    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();

        if(root == null)
        return ans;

        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        queue.add(new Pair(root, 0));

        while(!queue.isEmpty())
        {
            int currentSize = queue.size();
            while(currentSize-- > 0)
            {
                Pair current = queue.poll();
            
                if(!map.containsKey(current.col))
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

