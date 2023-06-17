/*
 * Using the MergeTwoSortedLists code, we can pass two lists at a time, merge them, and use that list to merge it with the next available list. We keep doing that until
 * there are no more lists remaining.
 */

public class FlattenALinkedList {
    public static Node flattenLinkedList(Node head) {
        while(head.next != null)
        {
            Node nextList = head.next.next;
            head = sortTwoLists(head, head.next);
            head.next = nextList;
        }

        return head;
    }

    public static Node sortTwoLists(Node first, Node second) {
		Node newNode = new Node(0);
        Node head = newNode;
        first.next = null;
        second.next = null;

        while(first != null && second != null)
        {
            if(first.data < second.data)
            {
                newNode.child = first;
                first = first.child;
            }

            else
            {
                newNode.child = second;
                second = second.child;
            }

            newNode = newNode.child;
        }

        if(first != null)
        newNode.child = first;

        if(second != null)
        newNode.child = second;

        return head.child;
	}

    static class Node {
     public int data;
     public Node next;
     public Node child;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.child = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.child = null;
     }
     Node(int data, Node next, Node child)
     {
         this.data = data;
         this.next = next;
         this.child = child;
     }
 }
}
