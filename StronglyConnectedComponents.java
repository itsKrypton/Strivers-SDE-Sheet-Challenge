import java.util.*;

public class StronglyConnectedComponents {

    private static void dfs(int v, int[] visited, List<List<Integer>> adj, Stack<Integer> st) {
        visited[v] = 1;

        for (int n : adj.get(v)) {
            if (visited[n] == 0) {
                dfs(n, visited, adj, st);
            }
        }

        st.push(v);
    }

    private static void Dfs(int v, int[] visited, List<List<Integer>> adj, List<Integer> temp) {
        visited[v] = 1;
        temp.add(v);

        for (int n : adj.get(v)) {
            if (visited[n] == 0) {
                Dfs(n, visited, adj, temp);
            }
        }
    }

    public static List<List<Integer>> stronglyConnectedComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        // Toposort
        int[] visited = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, adj, st);
            }
        }

        // Transpose
        List<List<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visited[i] = 0;
            transpose.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j : adj.get(i)) {
                transpose.get(j).add(i);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int c = st.pop();
            if (visited[c] == 1) continue;

            Dfs(c, visited, transpose, temp);
            ans.add(temp);
        }

        return ans;
    }
}
