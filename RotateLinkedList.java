public class RotateLinkedList {
    public static Node rotate(Node head, int k) {
        if(head == null || head.next == null)
        return head;

        Node current = head;
        int size = 1;
        while(current.next != null)
        {
            current = current.next;
            size++;
        }
        k = k%size;
        if(k == 0)
        return head;

        current.next = head;

        Node newStart = split(head, size-k);
        return newStart;
    }

    public static Node split(Node head, int k)
    {
        Node prev = null;
        Node current = head;
        for(int i = 0; i < k; i++)
        {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        return current;
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
