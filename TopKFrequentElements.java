import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.freq, a.freq));
        HashMap<Integer, Integer> table = new HashMap<>();
        int[] ans = new int[k];

        for(int num : nums)
        table.put(num, table.getOrDefault(num, 0) + 1);

        for(Entry<Integer, Integer> values : table.entrySet())
        pq.add(new Pair(values.getKey(), values.getValue()));

        while(k-- > 0)
        ans[k] = pq.remove().number;

        return ans;
    }

    public class Pair {
        private int number;
        private int freq;

        public Pair (int number, int freq)
        {
            this.number = number;
            this.freq = freq;
        }
    }
}
