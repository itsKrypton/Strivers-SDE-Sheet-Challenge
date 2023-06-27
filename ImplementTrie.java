// https://leetcode.com/problems/implement-trie-prefix-tree/description/

/*
 * Trie is basically a collection of nodes where each node contains an array of length 26, signifying 26 alphabets, and a boolean flag. The flag tells if a word ends
 * at that node. See the code and you will understand.
 */

public class ImplementTrie {
    Node root;

    public ImplementTrie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        Node currentNode = root;

        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);

            if(!currentNode.containsKey(ch))
            currentNode.put(ch);

            currentNode = currentNode.getKey(ch);
        }

        currentNode.setEnd();
    }
    
    public boolean search(String word) {
        Node currentNode = root;

        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);

            if(!currentNode.containsKey(ch))
            return false;

            currentNode = currentNode.getKey(ch);
        }

        return (currentNode.isEnd());
    }
    
    public boolean startsWith(String prefix) {
        Node currentNode = root;

        for(int i = 0; i < prefix.length(); i++)
        {
            char ch = prefix.charAt(i);

            if(!currentNode.containsKey(ch))
            return false;

            currentNode = currentNode.getKey(ch);
        }

        return true;
    }

    public class Node {
        private Node links[];
        private boolean flag;

        public Node ()
        {
            this.links = new Node[26];
            this.flag = false;
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

        public void setEnd()
        {
            this.flag = true;
        }

        public boolean isEnd()
        {
            return this.flag;
        }
    }
}
