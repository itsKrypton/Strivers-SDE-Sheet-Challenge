import java.util.*;

public class DFSTraversal {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < v; i++)
        adj.add(new ArrayList<>());

        for(ArrayList<Integer> edge : edges)
        {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        boolean[] visited = new boolean[v];
        ArrayList<ArrayList<Integer>> dfs = new ArrayList<>();

        for(int i = 0; i < v; i++)
        {
            if(!visited[i])
            {
                ArrayList<Integer> currentDfs = new ArrayList<>();
                dfs(i, adj, currentDfs, visited);
                dfs.add(currentDfs);
            }
        }

        return dfs;
    }

    public static void dfs(int currentVertex, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs, boolean[] visited)
    {
        visited[currentVertex] = true;
        dfs.add(currentVertex);

        for(int nVertex : adj.get(currentVertex))
        {
            if(!visited[nVertex])
            dfs(nVertex, adj, dfs, visited);
        }
    }
}
