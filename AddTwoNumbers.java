// https://leetcode.com/problems/add-two-numbers/description/

// Having problems with submitting this problem on CodeStudio

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode output = new ListNode();
        ListNode head = output;

        while(l1 != null || l2 != null || carry != 0)
        {
            int num1 = (l1 == null) ? 0 : l1.val;
            int num2 = (l2 == null) ? 0 : l2.val;
            int currentSum = num1 + num2 + carry;

            carry = (currentSum >= 10) ? 1 : 0;
            ListNode newNode = new ListNode(currentSum % 10);

            output.next = newNode;
            output = output.next;

            if(l1 != null)
            l1 = l1.next;

            if(l2 != null)
            l2 = l2.next;
        }

        return head.next;
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
