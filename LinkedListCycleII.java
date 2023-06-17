public class LinkedListCycleII {
    public static Node firstNode(Node head) {
        Node fast = detectCycle(head);

        if(fast == null) return fast;

        Node slow = head;

        while(slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static Node detectCycle(Node head)
    {
        Node slow = head;
        Node fast = head;

        do
        {
            if(fast == null || fast.next == null)
            return null;

            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow != fast);

        return slow;
    }

    class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }
}
