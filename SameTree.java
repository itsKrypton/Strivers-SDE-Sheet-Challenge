public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null)
        return (p == q);

        boolean left = isSameTree(p.left, q.left);
        if(!left) return false;
        boolean right = isSameTree(p.right, q.right);
        if(!right) return false;

        return (p.val == q.val);
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
