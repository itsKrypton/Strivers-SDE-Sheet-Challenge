// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/ and https://www.codingninjas.com/codestudio/problems/delete-kth-node-from-end_8230725?challengeSlug=striver-sde-challenge

/*
 * Move the fast pointer n times, then move slow and fast pointers till fast reaches the end, here we would have reached the nth - 1 node from the back. Then remove the
 * nth node. Try to do a dry run with an example.
 */

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newNode = new ListNode(0, head);
        ListNode slow = newNode;
        ListNode fast = newNode;

        for(int i = 0; i < n; i++)
        fast = fast.next;

        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return newNode.next;
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
