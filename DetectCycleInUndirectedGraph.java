// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

/*
* BFS:
* Here, we keep a track of the parent node during the BFS traversal and at any point, if the neighbor node is visited and it's not equal to the parent node then it
* means that someone else has already visited it and it was not the current path which basically means that a cycle exists.
* 
* DFS:
* In DFS, we traverse and whenever we come to a node that is already visited and it's not the current vertex's parent node then we return true and while making dfs calls
* if the call is returning true then we don't need to make further calls. Just keep returning true.
*/

import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;

public class DetectCycleInUndirectedGraph {
    // Using BFS
    /* public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++)
        {
            if(!visited[i])
            {
                if(detect(i, adj, visited)) return true;
            }
        }

        return false;
    }

    public boolean detect(int vertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited)
    {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(vertex, -1));
        visited[vertex] = true;

        while(!queue.isEmpty())
        {
            Pair currentVertex = queue.remove();

            for(int nVertex : adj.get(currentVertex.vertex))
            {
                if(!visited[nVertex])
                {
                    queue.add(new Pair(nVertex, currentVertex.vertex));
                    visited[nVertex] = true;
                }

                else if(currentVertex.parentVertex != nVertex) return true;
            }
        }

        return false;
    } */

    // Using DFS
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++)
        {
            if(!visited[i])
            {
                if(detect(new Pair(i, -1), adj, visited)) return true;
            }
        }

        return false;
    }

    public boolean detect(Pair currentVertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited)
    {
        visited[currentVertex.vertex] = true;

        for(int nVertex : adj.get(currentVertex.vertex))
        {
            if(!visited[nVertex])
            {
                visited[nVertex] = true;
                if(detect(new Pair(nVertex, currentVertex.vertex), adj, visited)) return true;
            }

            else if(currentVertex.parentVertex != nVertex) return true;
        }

        return false;
    }

    public class Pair {
        private int vertex;
        private int parentVertex;

        public Pair(int vertex, int parentVertex)
        {
            this.vertex = vertex;
            this.parentVertex = parentVertex;
        }
    }
}
 