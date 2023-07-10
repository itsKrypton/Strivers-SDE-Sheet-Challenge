import java.util.ArrayList;

public class LeftViewOfBinaryTree {
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null)
        return ans;

        find(root, 0, ans);
        return ans;
    }

    public static void find(TreeNode<Integer> root, int row, ArrayList<Integer> ans)
    {
        if(root == null)
        return;

        if(row == ans.size()) 
        ans.add(root.data);

        find(root.left, row + 1, ans);
        find(root.right, row + 1, ans);
    }

    public class TreeNode<T> {
        T data;
        int val;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode<T> left, TreeNode<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

