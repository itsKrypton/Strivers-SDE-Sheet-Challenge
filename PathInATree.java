// Basic backtracking, dfs already goes in depth first so keep adding the current node in the path while we go down and remove the node from path while returning back.

import java.util.ArrayList;

public class PathInATree {
    public static ArrayList<Integer> pathInATree(TreeNode root, int x) {
        ArrayList<Integer> path = new ArrayList<>();
        helper(root, x, path);
        return path;
    }

    public static boolean helper(TreeNode root, int x, ArrayList<Integer> path)
    {
        if(root == null)
        return false;

        path.add(root.data);

        if(root.data == x)
        return true;

        if(helper(root.left, x, path) || helper(root.right, x, path))
        return true;

        path.remove(path.size() - 1);

        return false;
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
