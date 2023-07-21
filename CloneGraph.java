/*
 * Use a hashmap to store the current nodes value and the link to the new created node. Use a queue to do a BFS traversal of the current graph to create a new graph.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        if(node == null) return null;
        
        queue.add(node);
        Node start = new Node(node.val);
        map.put(node.val, start);

        while(!queue.isEmpty())
        {
            Node currentVertex = queue.remove();
            Node newNode = map.get(currentVertex.val); // The new node will always be there as we are creating the node in the for loop.

            for(Node nVertex : currentVertex.neighbors) // For every neighbor of current node.
            {
                Node newNVertex = map.getOrDefault(nVertex.val, new Node(nVertex.val)); // Get the neighbor vertex if already present or create a new one.

                if(!map.containsKey(nVertex.val)) // If it's not already visited, visit the node and add it in the queue.
                {
                    map.put(nVertex.val, newNVertex);
                    queue.add(nVertex);
                }

                newNode.neighbors.add(newNVertex); // Connect the new neighbor node to new current node.
            }
        }

        return start;
    }

    class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
}
