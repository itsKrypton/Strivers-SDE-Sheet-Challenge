import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNewRightPointersBinaryTree {
    public Node connect(Node root) {
        if(root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            int currentSize = queue.size();

            for(int i = 0; i < currentSize; i++)
            {
                Node current = queue.remove();

                if(i < currentSize - 1)
                current.next = queue.peek();

                if(current.left != null) // Only one condition because we know it's a perfect BT.
                {
                    queue.add(current.left);
                    queue.add(current.right);
                }
            }
        }

        return root;
    }

    public class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node() {};
    }
}
