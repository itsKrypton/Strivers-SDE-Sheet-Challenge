public class CopyListWithRandomPointer {
    public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		// Placing dupe nodes after real nodes
        LinkedListNode<Integer> curr = head;
        while(curr != null)
        {
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Connecting dupe nodes random pointers.
        curr = head;
        while(curr != null)
        {
            curr.next.random = (curr.random != null) ? curr.random.next : null;
            curr = curr.next.next;
        }

        // Separating original list and dupe list
        curr = head;
        LinkedListNode<Integer> dupeHead = (curr != null) ? curr.next : null;
        while(curr != null)
        {
            LinkedListNode<Integer> nextNode = curr.next.next;
            curr.next.next = (nextNode != null) ? nextNode.next : null;
            curr.next = nextNode;
            curr = curr.next;
        }

        return dupeHead;
	}

    static class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }
}
