// https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bfs_of_graph

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSInGraph {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[V];

        queue.add(0);
        visited[0] = true;

        while(!queue.isEmpty())
        {
            int currentVertex = queue.remove();
            bfs.add(currentVertex);

            for(int nVertex : adj.get(currentVertex))
            {
                if(!visited[nVertex])
                {
                    queue.add(nVertex);
                    visited[nVertex] = true;
                }
            }
        }

        return bfs;
    }
}
