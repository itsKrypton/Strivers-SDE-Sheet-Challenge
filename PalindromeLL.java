public class PalindromeLL {
    public static boolean isPalindrome(LinkedListNode<Integer> head) {
        if(head == null || head.next == null)
        return true;

        LinkedListNode<Integer> mid = getMid(head);
        LinkedListNode<Integer> reversedStart = reverseList(mid);

        LinkedListNode<Integer> midCopy = reversedStart;
        LinkedListNode<Integer> start = head;
        while(start != null && midCopy != null)
        {
            if(!start.data.equals(midCopy.data))
            return false;

            start = start.next;
            midCopy = midCopy.next;
        }
        //reverseList(reversedStart);
        
        return true;
	}

    public static LinkedListNode<Integer> getMid(LinkedListNode<Integer> head)
    {
        LinkedListNode<Integer> midPrev = null;
        while(head != null && head.next != null)
        {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        return midPrev;
    }

    public static LinkedListNode<Integer> reverseList(LinkedListNode<Integer> head) {
        if(head == null)
        return null;

        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> curr = head;
        LinkedListNode<Integer> next = curr.next;

        while(curr != null)
        {
            curr.next = prev;
            prev = curr;
            curr = next;

            if(next != null)
            next = next.next;
        }

        return prev;
    }

    class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}
}
