public class ReverseNodesInKGroup {
    public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
        Node curr = head;
        Node prevStart = null;
        boolean firstBlock = true;
        for (int i = 0; i < n && curr != null; i++)
        {
            if(b[i] == 0) continue;

            Node first = curr;
            Node top = first;
            Node second = first.next;
            for (int j = 0; j < b[i] - 1; j++){
                if(second == null) break;

                Node temp = first;
                first = second;
                second = second.next;
                first.next = temp;   
            }
			
            if (firstBlock) 
            {
                firstBlock = false;
                head = first;
            }

            if(prevStart != null)
            prevStart.next = first;

            curr = second;
            prevStart = top;
        }

        if(prevStart != null)
        prevStart.next = curr;
        
        return head;
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
