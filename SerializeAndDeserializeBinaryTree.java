//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

/*
 * Do a level order traversal and keep appending current value to a string and if null then append "x". While deserializing, add first value to queue and then loop through
 * all the other entries of the string. Remove node from queue and check for next two characters of string and add it to current left and right.
 */

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        deserialize("1 2 3 x x 4 5 x x x x");
    }
    // Staight forward level order traversal if current value is null then add x to string else add the value.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        if(root == null)
        return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val + " ");

        while(!queue.isEmpty())
        {
            TreeNode current = queue.poll();

            if(current == null)
            {
                sb.append('x' + " ");
                continue;
            }

            sb.append(current.val + " ");
            queue.add(current.left);
            queue.add(current.right);
        }
        return sb.toString();
    }

    public static TreeNode deserialize(String data) {
        if(data == null || data == "")
        return null;

        String[] values = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        queue.add(root);

        for(int i = 1; i < values.length; i++)
        {
            TreeNode current = queue.poll();

            if(!values[i].equals("x"))
            {
                TreeNode left = new TreeNode(Integer.valueOf(values[i]));
                current.left = left;
                queue.add(left);
            }

            if(!values[++i].equals("x"))
            {
                TreeNode right = new TreeNode(Integer.valueOf(values[i]));
                current.right = right;
                queue.add(right);
            }
        }

        return root;
    }

    public static class TreeNode {
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
