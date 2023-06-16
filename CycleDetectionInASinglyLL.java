public class CycleDetectionInASinglyLL {
    public static boolean detectCycle(Node head) {
        Node slow = head;
        Node fast = head;

        do
        {
            if(fast == null || fast.next == null)
            return false;

            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow != fast);

        return true;
    }

    static class Node {
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
