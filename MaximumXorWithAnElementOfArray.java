import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaximumXorWithAnElementOfArray {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        ArrayList<ArrayList<Integer>> offlineQuery = new ArrayList<>();
        Arrays.sort(nums);
        int[] answer = new int[queries.length];

        for(int i = 0; i < queries.length; i++)
        {
            ArrayList<Integer> query = new ArrayList<>();
            query.add(queries[i][0]);
            query.add(queries[i][1]);
            query.add(i);
            offlineQuery.add(query);
        }

        Collections.sort(offlineQuery, (a,b) -> Integer.compare(a.get(1), b.get(1)));

        Trie trie = new Trie();
        int numIndex = 0;
        for(int i = 0; i < offlineQuery.size(); i++)
        {
            while(numIndex < nums.length && nums[numIndex] <= offlineQuery.get(i).get(1))
            trie.insert(nums[numIndex++]);

            answer[offlineQuery.get(i).get(2)] = (trie.isEmpty()) ? -1 : trie.getMaxXor(offlineQuery.get(i).get(0));
        }

        return answer;
    }

    public class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }
    
        public void insert(int num) {
            Node currentNode = root;

            for(int i = 31; i >= 0; i--)
            {
                int bit = (num >> i) & 1; // Right shifting the bits of the current number i times to get the ith bit and then we and with 1 to get that bit. (0 & 1 = 0, 1 & 1 = 2)

                if(!currentNode.containsKey(bit))
                currentNode.put(bit);

                currentNode = currentNode.getKey(bit);
            }
        }

        public int getMaxXor(int num) {
            Node currentNode = root;

            int max = 0;
            for(int i = 31; i >= 0; i--)
            {
                int bit = (num >> i) & 1;

                if(currentNode.containsKey(1 - bit))
                {
                    max = max | (1 << i); // Left shiting 1 i times and then flipping maxes ith bit to 1 by the |. (0 | 1 = 1, 1 | 1 = 1)
                    currentNode = currentNode.getKey(1 - bit);
                }

                else
                currentNode = currentNode.getKey(bit);
            }

            return max;
        }

        public boolean isEmpty() {
            Node currentNode = root;

            return (!currentNode.containsKey(0) && !currentNode.containsKey(1));
        }
    }

    public class Node {
        private Node links[];

        public Node ()
        {
            this.links = new Node[2];
        }

        public boolean containsKey(int num)
        {
            return (this.links[num] != null);
        }

        public Node getKey(int num)
        {
            return (this.links[num]);
        }

        public void put(int num)
        {
            this.links[num] = new Node();
        }
    }
    /* public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie = new Trie();

        for(int num : nums)
        trie.insert(num);

        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++)
        answer[i] = trie.getMaxXor(queries[i][0], queries[i][1]);

        return answer;
    }

    public class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }
    
        public void insert(int num) {
            Node currentNode = root;

            for(int i = 31; i >= 0; i--)
            {
                int bit = (num >> i) & 1;

                if(!currentNode.containsKey(bit))
                currentNode.put(bit);

                currentNode = currentNode.getKey(bit);
            }
        }

        public int getMaxXor(int num, int limit) {
            Node currentNode = root;
            boolean flippedOne = false;

            int max = 0;
            for(int i = 31; i >= 0; i--)
            {
                int bitOfNum = (num >> i) & 1;
                int bitOfLimit = (limit >> i) & 1;

                if(!flippedOne && bitOfLimit == 0)
                {
                    if(!currentNode.containsKey(0)) return -1;
                    currentNode = currentNode.getKey(0);

                    if(bitOfNum == 1)
                    max = max | (1 << i);
                }

                else
                {
                    if(currentNode.containsKey(1 - bitOfNum)) 
                    {
                        max = max | (1 << i);
                        currentNode = currentNode.getKey(1 - bitOfNum);

                        if(!flippedOne && bitOfLimit == 1 && (1 - bitOfNum) == 0)
                        flippedOne = true;
                    }

                    else
                    {
                        currentNode = currentNode.getKey(bitOfNum);

                        if(!flippedOne && bitOfLimit == 1 && bitOfNum == 0)
                        flippedOne = true;
                    }    
                }
            }

            return max;
        }
    }

    public class Node {
        private Node links[];

        public Node ()
        {
            this.links = new Node[2];
        }

        public boolean containsKey(int num)
        {
            return (this.links[num] != null);
        }

        public Node getKey(int num)
        {
            return (this.links[num]);
        }

        public void put(int num)
        {
            this.links[num] = new Node();
        }
    } */
}
