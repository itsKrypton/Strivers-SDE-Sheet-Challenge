// https://practice.geeksforgeeks.org/problems/bipartite-graph/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

/*
* Simple BFS or DFS traversal with a slight change. Whenever a nVertex is already visited then check if it's the opposite colour of current vertex, if it's not then
* immediately return false otherwise continue with the normal BFS. Here 1 and 2 represents two different colors and 0 means vertex is not visited.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // BFS
        /* int[] visited = new int[V];

        for(int i = 0; i < V; i++)
        {
            if(visited[i] == 0)
            if(!bfs(i, adj, visited)) return false;
        }

        return true; */

        // DFS
        int[] visited = new int[V];

        for(int i = 0; i < V; i++)
        {
            if(visited[i] == 0)
            {
                visited[i] = 1;
                if(!dfs(i, adj, visited)) return false;
            }
        }

        return true;
    }

    public boolean bfs(int startingVertex, ArrayList<ArrayList<Integer>> adj, int[] visited)
    {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startingVertex);
        visited[startingVertex] = 1;

        while(!queue.isEmpty())
        {
            int currentVertex = queue.remove();

            for(int nVertex : adj.get(currentVertex))
            {
                if(visited[nVertex] == 0)
                {
                    queue.add(nVertex);
                    visited[nVertex] = (visited[currentVertex] == 1) ? 2 : 1;
                }

                else if(visited[nVertex] == visited[currentVertex]) return false;
            }
        }

        return true;
    }

    public boolean dfs(int currentVertex, ArrayList<ArrayList<Integer>> adj, int[] visited)
    {
        for(int nVertex : adj.get(currentVertex))
        {
            if(visited[nVertex] == 0)
            {
                visited[nVertex] = (visited[currentVertex] == 1) ? 2 : 1;
                if(!dfs(nVertex, adj, visited)) return false;
            }

            else if(visited[nVertex] == visited[currentVertex]) return false;
        }

        return true;
    }
}
