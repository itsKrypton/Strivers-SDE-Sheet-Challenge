// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/description/

/*
 * Insert all the numbers in their bit representation into the trie. Iterate through all the numbers again and for every bit in the current number, check if the opposite
 * bit exists in trie, if it does then choose that because opposite bits xor gives us 1 and more 1's on the left side means a bigger number.
 */

public class MaximumXorOfTwoNumbersInArray {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();

        for(int num : nums)
        trie.insert(num);

        int max = Integer.MIN_VALUE;
        for(int num : nums)
        max = Math.max(max, trie.getMaxXor(num));

        return max;
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
}
