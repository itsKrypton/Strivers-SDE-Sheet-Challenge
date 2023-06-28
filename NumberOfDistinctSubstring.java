// Insert characters one by one and increase a counter for every distinct insertion.
// T: O(n^2)

public class NumberOfDistinctSubstring {
    public static int distinctSubstring(String word) {
        Node root = new Node();

        int distinctElements = 0;
        for(int i = 0; i < word.length(); i++)
        {
            Node node = root;
            for(int j = i; j < word.length(); j++)
            {
                char ch = word.charAt(j);

                if(!node.containsKey(ch))
                {
                    node.put(ch);
                    distinctElements++;
                }

                node = node.getKey(ch);
            }
        }

        return distinctElements;
    }

    public static class Node {
        private Node links[];

        public Node ()
        {
            this.links = new Node[26];
        }

        public boolean containsKey(char ch)
        {
            return (this.links[ch - 'a'] != null);
        }

        public Node getKey(char ch)
        {
            return (this.links[ch - 'a']);
        }

        public void put(char ch)
        {
            this.links[ch - 'a'] = new Node();
        }
    }
}
