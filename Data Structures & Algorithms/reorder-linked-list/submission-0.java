/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    private ListNode reverseLL(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null) {
            ListNode succ = temp.next;
            temp.next = prev;
            prev = temp;
            temp = succ;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        // we have to find the middle node of linked list 
        // so that we can reverse the other half of Linked List 
        // After reversing we will put 2 pointers - at first half head node and second half reverse List starting node 
        // by moving the pointer we will create a new Linked list which will have value in following way - [0, n-1, 1, n-2, 2, n-3, ...]

        // setp 1 - find middle of LL using slow and fast pointer 
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l1 = head; 
        ListNode l2 = reverseLL(slow.next);
        slow.next = null;
        ListNode dummyNode = new ListNode(-1);
        ListNode templ1 = null, templ2=null;
        while(l1 != null && l2 != null) {
            templ1 = l1.next;
            l1.next = l2;
            templ2 = l2.next;
            l2.next = templ1;
            l1=templ1;
            l2=templ2;
        }
    }
}
