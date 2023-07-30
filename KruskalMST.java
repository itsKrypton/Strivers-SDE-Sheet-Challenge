import java.util.Arrays;

class KruskalEdge implements Comparable<KruskalEdge> {
    int src;
    int dest;
    int weight;

    public KruskalEdge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(KruskalEdge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; ++i)
            parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void unionSets(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY])
                parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY])
                parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}

public class KruskalMST {
    public static int kruskalMST(int n, int[][] edges) {
        KruskalEdge[] kruskalEdges = new KruskalEdge[edges.length];
        for (int i = 0; i < edges.length; i++) {
            kruskalEdges[i] = new KruskalEdge(edges[i][0], edges[i][1], edges[i][2]);
        }

        Arrays.sort(kruskalEdges);

        int mstWeight = 0;
        DisjointSet ds = new DisjointSet(n);

        for (KruskalEdge edge : kruskalEdges) {
            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;

            // Check if adding this edge creates a cycle
            if (ds.find(u) != ds.find(v)) {
                mstWeight += weight;
                ds.unionSets(u, v);
            }
        }

        return mstWeight;
    }
}
