// https://leetcode.com/problems/lru-cache/

/*
 * We use a hashmap to track the keys and their nodes for O(1) retrieval and a doubly linked list to insert new nodes from head and remove old nodes from tail.
 * Whenever keys added, updated or retrieved, it becomes the most recently used and is added to the front of the list and the least recently used nodes are at the
 * tail of the DLL.
 */

import java.util.*;

public class LRUCache {
    Node head;
    Node tail;
    HashMap<Integer, Node> cache;
    int capacity;
    int count;

    public LRUCache(int capacity) {
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        this.head.next = this.tail;
        this.tail.prev = this.head;

        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.count = 0;
    }
    
    public int get(int key) {
        if(!this.cache.containsKey(key)) return -1;

        Node node = this.cache.get(key);
        remove(node);
        insert(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        if(this.count == this.capacity && !this.cache.containsKey(key))
        remove(this.tail.prev);

        if(!this.cache.containsKey(key))
        {
            Node newNode = new Node(key, value);
            insert(newNode);
        }

        else
        {
            Node node = this.cache.get(key);
            node.value = value;
            remove(node);
            insert(node);
        }
    }

    private void remove(Node node)
    {
        this.cache.remove(node.key);
        this.count--;

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node)
    {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

        this.count++;
        this.cache.put(node.key, node);
    }

    public class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}