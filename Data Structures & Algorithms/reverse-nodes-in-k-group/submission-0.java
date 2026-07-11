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

    private ListNode findKthNode(ListNode temp, int k) {
        while(temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp; 
    }

    private void reverse(ListNode temp) {
        ListNode prev = null;
        while(temp != null) {
            ListNode succ = temp.next;
            temp.next = prev;
            prev = temp;
            temp = succ;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // 
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null) {
            // find kth node 
            ListNode kthNode = findKthNode(temp, k-1);
            if(kthNode == null) {
                if(prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            } 

            // we have to reverse, before reversing 
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);
            if(head == temp) {
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }
            // reconnect prev reverse and current reverse group 
            prevNode = temp;
            temp = nextNode;

        }
        return head;
    }
}
