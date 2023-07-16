import java.util.ArrayList;
import java.util.Stack;

/*
 * Do what the question says, first traverse all the left nodes until the leaf node (write a function to check whether leaf node or not), then traverse all the leaf nodes 
 * (preorder), then traverse the right nodes but use a stack to store the answers first as we need to add the nodes in the list in reverse order as we are traversing up.
 */

public class BoundaryTraversalOfBinaryTree {
    public static ArrayList<Integer> traverseBoundary(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>();
        ans.add(root.data);

        if(isLeaf(root))
        return ans;

        findLeftNodes(root, ans);
        findLeafNodes(root, ans);
        findRightNodes(root, ans);
        
        return ans;
	}
    
    public static void findLeftNodes(TreeNode root, ArrayList<Integer> ans)
    {
        if(root.left == null)
        return;
        
        TreeNode currentNode = root.left;
        while(!isLeaf(currentNode))
        {
            ans.add(currentNode.data);
            currentNode = (currentNode.left == null) ? currentNode.right : currentNode.left;
        }
    }

    public static void findLeafNodes(TreeNode root, ArrayList<Integer> ans)
    {
        if(root == null)
        return;

        findLeafNodes(root.left, ans);
        findLeafNodes(root.right, ans);

        if(isLeaf(root))
        ans.add(root.data);
    }

    public static void findRightNodes(TreeNode root, ArrayList<Integer> ans)
    {
        if(root.right == null)
        return;

        TreeNode currentNode = root.right;
        Stack<Integer> stack = new Stack<>();
        while(!isLeaf(currentNode))
        {
            stack.push(currentNode.data);
            currentNode = (currentNode.right == null) ? currentNode.left : currentNode.right;
        }

        while(!stack.isEmpty())
        ans.add(stack.pop());
    }

    public static boolean isLeaf(TreeNode root)
    {
        return (root.right == null && root.left == null);
    }

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int data) { this.data = data; }
        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
