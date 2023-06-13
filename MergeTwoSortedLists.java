public class MergeTwoSortedLists {
    // O(n) time and constant space
    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		LinkedListNode<Integer> newNode = new LinkedListNode<>(null);
        LinkedListNode<Integer> head = newNode;

        while(first != null && second != null)
        {
            if(first.data < second.data)
            {
                newNode.next = first;
                first = first.next;
            }

            else
            {
                newNode.next = second;
                second = second.next;
            }

            newNode = newNode.next;
        }

        if(first != null)
        newNode.next = first;

        if(second != null)
        newNode.next = second;

        return head.next;
	}

    static class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }
}
