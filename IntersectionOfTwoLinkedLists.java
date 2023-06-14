public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Difference in length method
        /* int lengthA = 0, lengthB = 0;
        ListNode curr1 = headA, curr2 = headB;
        while(curr1 != null || curr2 != null)
        {
            if(curr1 != null) 
            {
                lengthA++;
                curr1 = curr1.next;
            }

            if(curr2 != null) 
            {
                lengthB++;
                curr2 = curr2.next;
            }
        }

        for(int i = 0; i < Math.abs(lengthA - lengthB); i++)
        {
            if(lengthA > lengthB) headA = headA.next;

            else if(lengthA < lengthB) headB = headB.next;
        }

        while(headA != null && headB != null)
        {
            if(headA == headB) return headA;
        }

        return null; */

        // Without the difference, when one of them reaches null, start traversing from the next list at that point both the traversals must collide
        ListNode curr1 = headA, curr2 = headB;

        while(curr1 != curr2)
        {
            curr1 = (curr1 == null) ? headB : curr1.next;
            curr2 = (curr2 == null) ? headA : curr2.next;
        }

        return curr1;
    }

    public class ListNode 
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
