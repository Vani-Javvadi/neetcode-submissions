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
    public boolean hasCycle(ListNode head) {
        // slow and fast pointer hare and tortoise 
        // slow will move 1 step and fast moves 2 steps 
        // if there is a cycle , definitely they will meet at one poistion 
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        if(slow != null && fast != null && slow == fast) {
            return true;
        }
        return false;
    }
}
