import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Basically a BFS traversal with PQ. Have a distance array and set all nodes to infinity with source as 0 and add the source to PQ. For every node, if current distance,
 * plus neighbor node distance is less than current smallest distance of array then update the distance array and insert it into PQ.
 */

public class ImplementingDijkstraAlgorithm {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        /* PriorityQueue<Pair> queue = new PriorityQueue<>(new PairComparator()); */
        int[] distance = new int[V];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[S] = 0;
        queue.add(new Pair(0, S));
        
        while(!queue.isEmpty())
        {
            Pair currentVertex = queue.remove();
            int currentDistance = currentVertex.weight;
            
            for(ArrayList<Integer> nVertexList : adj.get(currentVertex.node))
            {
                int nVertex = nVertexList.get(0);
                int nVertexDistance = nVertexList.get(1);
                
                if(currentDistance + nVertexDistance < distance[nVertex])
                {
                    distance[nVertex] = currentDistance + nVertexDistance;
                    queue.add(new Pair(distance[nVertex], nVertex));
                }
            }
        }
        
        return distance;
    }

    public static class Pair {
        private int weight;
        private int node;

        public Pair(int weight, int node)
        {
            this.weight = weight;
            this.node = node;
        }
    }
}
