// Just use a trie, insert all given words and for every word, check if every prefix of it has a ending at that point, if yes, then return true else false.

public class CompleteString {
    public static String completeString(int n, String[] a) {
    Trie trie = new Trie();

    for(String word : a)
    trie.insert(word);
    
    String answer = "";

    for(String word : a)
    {
      if(trie.checkCompleteString(word))
      {
        if(word.length() > answer.length())
        answer = word;

        else if(word.length() == answer.length() && word.compareTo(answer) < 0)
        answer = word;
      }
    }

    return answer.equals("") ? "None" : answer;
  }

  public static class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) 
    {
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

    public boolean checkCompleteString(String word)
    {
        Node currentNode = root;

        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);

            if(!currentNode.containsKey(ch) || !currentNode.getKey(ch).isEnd())
            return false;

            currentNode = currentNode.getKey(ch);
        }

        return true;
    }
  }

  public static class Node {
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
