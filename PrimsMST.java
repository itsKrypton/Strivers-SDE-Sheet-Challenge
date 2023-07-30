import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsMST {
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g) {
        List<Map<Integer, Integer>> adj = new ArrayList<Map<Integer, Integer>>();
        for (int i = 0; i <= n; i++) {
            adj.add(new HashMap<Integer, Integer>());
        }
        for (ArrayList<Integer> edge : g) {
            Map<Integer, Integer> u = adj.get(edge.get(0));
            Map<Integer, Integer> v = adj.get(edge.get(1));
            if (!u.containsKey(edge.get(1)) || u.get(edge.get(1)) > edge.get(2)) {
                u.put(edge.get(1), edge.get(2));
                v.put(edge.get(0), edge.get(2));
            }
        }
        int[] weight = new int[n + 1];
        int[] parent = new int[n + 1];
        boolean[] inMst = new boolean[n + 1];
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[1] = 0;
        // int[2] - (node, weight)
        Queue<int[]> queue = new PriorityQueue<int[]>((s1, s2) -> Integer.compare(s1[1], s2[1]));
        queue.offer(new int[] { 1, 0 });
        ArrayList<ArrayList<Integer>> mst = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            int[] uw = queue.poll();
            while (inMst[uw[0]]) {
                uw = queue.poll();
            }
            inMst[uw[0]] = true;
            if (i > 0) {
                ArrayList<Integer> edge = new ArrayList<Integer>();
                edge.add(uw[0]);
                edge.add(parent[uw[0]]);
                edge.add(weight[uw[0]]);
                mst.add(edge);
            }
            for (Map.Entry<Integer, Integer> vw : adj.get(uw[0]).entrySet()) {
                if (!inMst[vw.getKey()] && weight[vw.getKey()] > vw.getValue()) {
                    parent[vw.getKey()] = uw[0];
                    weight[vw.getKey()] = vw.getValue();
                    queue.offer(new int[] { vw.getKey(), vw.getValue() });
                }
            }
        }
        return mst;
    }
}
