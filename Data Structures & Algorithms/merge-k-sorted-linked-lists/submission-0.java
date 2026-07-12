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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        // consider first list as result , first try to sort 1,2 lists and then sort list 3 with sorted result of 1,2 
        ListNode head = lists[0];
        for(int i=1; i<lists.length; i++) {
            // take current list and try to sort the current one and result list pointed by p1
            ListNode p1 = head;
            ListNode p2 = lists[i];
            ListNode prev=null;
            while(p1 != null && p2 != null) {
                if(p1.val > p2.val) {
                    if(p1 == head) {
                        // ad p2 is lesser make p2 as head 
                        head = p2;
                    }
                    if(prev != null) {
                        prev.next = p2;
                    }
                    prev = p2;
                    p2 = p2.next;
                } else {
                    if(prev != null) {
                        prev.next = p1;
                    }
                    prev = p1;
                    p1=p1.next;
                }
            }
            if(p1 != null) {
                prev.next = p1;
            } else if (p2 != null) {
                prev.next = p2;
            }
        }
        return head;
    }
}
