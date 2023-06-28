/*
 * Similar to ImplementTrie, the difference being that here we need to know the count of word prefixes and word endings. So instead of boolean variables in node, we 
 * use int variable to store the count of prefixes and ending points.
 */

public class ImplementTrieII {
    Node root;

    public ImplementTrieII() {
        root = new Node();
    }

    public void insert(String word) {
        Node currentNode = root;

        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);

            if(!currentNode.containsKey(ch))
            currentNode.put(ch);

            currentNode = currentNode.getKey(ch);
            currentNode.incrementCountPrefix();
        }

        currentNode.incrementEndsWith();
    }

    public int countWordsEqualTo(String word) {
        Node currentNode = root;

        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);

            if(!currentNode.containsKey(ch) || currentNode.getKey(ch).getCountPrefix() <= 0)
            return 0;

            currentNode = currentNode.getKey(ch);
        }

        return (currentNode.getCountEndsWith());
    }

    public int countWordsStartingWith(String word) {
        Node currentNode = root;

        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);

            if(!currentNode.containsKey(ch) || currentNode.getKey(ch).getCountPrefix() <= 0)
            return 0;

            currentNode = currentNode.getKey(ch);
        }

        return (currentNode.getCountPrefix());
    }

    public void erase(String word) {
        Node currentNode = root;

        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);

            if(!currentNode.containsKey(ch) || currentNode.getKey(ch).getCountPrefix() <= 0)
            return;

            currentNode = currentNode.getKey(ch);
            currentNode.decrementCountPrefix();
        }

        currentNode.decrementEndsWith();
    }

    public class Node {
        private Node links[];
        private int countEndsWith;
        private int countPrefix;

        public Node ()
        {
            this.links = new Node[26];
            this.countEndsWith = 0;
            this.countPrefix = 0;
        }

        public boolean containsKey(char ch)
        {
            return (this.links[ch - 'a'] != null);
        }

        public Node getKey(char ch)
        {
            return (this.links[ch - 'a']);
        }

        public int getCountEndsWith() 
        {
            return this.countEndsWith;
        }

        public int getCountPrefix()
        {
            return this.countPrefix;
        }

        public void put(char ch)
        {
            this.links[ch - 'a'] = new Node();
        }

        public void incrementCountPrefix()
        {
            this.countPrefix++;
        }

        public void decrementCountPrefix()
        {
            this.countPrefix--;
        }

        public void incrementEndsWith()
        {
            this.countEndsWith++;
        }

        public void decrementEndsWith()
        {
            this.countEndsWith--;
        }
    }
}
