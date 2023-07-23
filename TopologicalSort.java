// https://practice.geeksforgeeks.org/problems/topological-sort/1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Stack;

public class TopologicalSort {
    /*
    * DFS Traversal
    * 
    * The idea is, after all the dfs traversals of a node is done, we put that node in a stack. All the nodes below the stack would have been placed in it only if it has 
    * been already been visited, that means, those nodes are after the current node. So the stack will naturally follow the linear ordering from top to bottom, with the
    * bottom nodes being after the upper nodes.
    */
    /* static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < V; i++)
        {
            if(!visited[i])
            dfs(i, adj, visited, stack);
        }
        
        int[] ans = new int[V];
        int i = 0;
        
        while(!stack.isEmpty())
        ans[i++] = stack.pop();
        
        return ans;
    }
    
    public static void dfs(int currentVertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack)
    {
        visited[currentVertex] = true;
        
        for(int nVertex : adj.get(currentVertex))
        {
            if(!visited[nVertex])
            dfs(nVertex, adj, visited, stack);
        }
        
        stack.push(currentVertex);
    } */

    /*
     * BFS Traversal Kahns Algo
     * 
     * Maintain an indegree array and insert the nodes having 0 indegree inside the queue because we know these nodes will always be in the front of answer as these nodes
     * will only have edges going outwards to other nodes. On every removal of queue node, reduce the indegree of all nodes connected to it as we are removing this node.
     */

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int[] indegree = new int[V];
        for(ArrayList<Integer> list : adj)
        {
            for(int node : list)
            indegree[node]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++)
        {
            if(indegree[i] == 0)
            queue.add(i);
        }
        
        int[] ans = new int[V];
        int i = 0;
        
        while(!queue.isEmpty())
        {
            int currentNode = queue.remove();
            ans[i++] = currentNode;
            
            for(int nVertex : adj.get(currentNode))
            {
                if(--indegree[nVertex] == 0)
                queue.add(nVertex);
            }
        }
        
        return ans;
    }
}
