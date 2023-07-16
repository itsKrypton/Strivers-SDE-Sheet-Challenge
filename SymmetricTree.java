/*
 * Similar to same tree, just send one left node and one right node of the current node in the recursion calls.
 */

public class SymmetricTree {
    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        return (root == null) ? true : find(root.left, root.right);
    }

    public static boolean find(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2)
    {
        if(node1 == null || node2 == null)
        return (node1 == node2);

        boolean left = find(node1.left, node2.right);
        if(!left) return false;
        boolean right = find(node1.right, node2.left);
        if(!right) return false;

        return (node1.data.equals(node2.data));
    }

    public class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;
        BinaryTreeNode() {}
        BinaryTreeNode(T data) { this.data = data; }
        BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
