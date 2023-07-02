// https://leetcode.com/problems/lfu-cache/description/

/*
 * Extension of LRUCache. Here we are maintaining hashmap for the key and their nodes but we are also maintaining another hashmap to store the frequencies and their DLLs
 * Newly added nodes are added in the first frequency DLL, updated nodes or retried nodes go in the next frequency DLL. If the capacity is full, least frequently 
 * used node is deleted and new node is added in the freq 1 list.
 */

import java.util.HashMap;

public class LFUCache {
    HashMap<Integer, Node> cache;
    HashMap<Integer, DLL> freqList;
    int capacity;
    int count;
    int minFrequency;

    public LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.freqList = new HashMap<>();
        this.capacity = capacity;
        this.count = 0;
        this.minFrequency = 0;
    }
    
    public int get(int key) {
        if(!this.cache.containsKey(key)) return -1;

        Node node = this.cache.get(key);
        updateNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key))
        {
            Node node = this.cache.get(key);
            node.value = value;
            updateNode(node);
        }

        else 
        {
            if(this.count == this.capacity)
            {
                DLL currentList = freqList.get(this.minFrequency);
                this.cache.remove(currentList.tail.prev.key);
                currentList.remove(currentList.tail.prev);
                this.count--;
            }

            DLL freqOneList = freqList.getOrDefault(1, new DLL());
            Node newNode = new Node(key, value);
            freqOneList.add(newNode);
            this.cache.put(key, newNode);
            this.freqList.put(1, freqOneList);
            this.count++;
            this.minFrequency = 1;
        }
    }

    private void updateNode(Node node) {
        DLL currentList = freqList.get(node.frequency);
        currentList.remove(node);
        node.frequency++;

        if(freqList.get(this.minFrequency).size == 0)
        this.minFrequency = node.frequency;

        DLL list = freqList.getOrDefault(node.frequency, new DLL());
        list.add(node);
        this.freqList.put(node.frequency, list);
    }

    public class Node {
        private int key;
        private int value;
        private int frequency;
        private Node next;
        private Node prev;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    public class DLL {
        Node head;
        Node tail;
        int size;

        public DLL()
        {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);

            this.head.next = this.tail;
            this.tail.prev = this.head;

            this.size = 0;
        }

        public void add(Node node)
        {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;

            this.size++;
        }

        public void remove(Node node)
        {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            this.size--;
        }
    }
}
