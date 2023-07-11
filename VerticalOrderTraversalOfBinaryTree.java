import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

/*
 * Use a tuple to store current node, col and row. Do normal traversal and at every insertion add the node, col and row in a TreeMap as treemap sorts according to 
 * key.
 */

public class VerticalOrderTraversalOfBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Stack<Tuple> stack = new Stack<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        stack.push(new Tuple(root, 0, 0));

        while(!stack.isEmpty())
        {
            Tuple current = stack.pop();
            
            if(!map.containsKey(current.col))
            map.put(current.col, new TreeMap<>());

            if(!map.get(current.col).containsKey(current.row))
            map.get(current.col).put(current.row, new PriorityQueue<>());

            map.get(current.col).get(current.row).add(current.node.val);

            if(current.node.right != null)
            stack.push(new Tuple(current.node.right, current.col + 1, current.row + 1));

            if(current.node.left != null)
            stack.push(new Tuple(current.node.left, current.col - 1, current.row + 1));
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> cols : map.values())
        {
            ans.add(new LinkedList<>());
            for(PriorityQueue<Integer> rows : cols.values())
            {
                while(!rows.isEmpty())
                ans.get(ans.size() - 1).add(rows.poll());
            }
        }

        return ans;
    }

    public class Tuple{
        TreeNode node;
        int col, row;
        Tuple(TreeNode node, int col, int row)
        {
            this.node = node;
            this.col = col;
            this.row = row;
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

