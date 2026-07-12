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
    private ListNode merge2SortedLists(ListNode p1, ListNode p2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                temp.next = p1;
                p1 = p1.next;
            } else {
                temp.next = p2;
                p2 = p2.next;
            }
            temp = temp.next;
        }
        if(p1 != null) {
            temp.next = p1;
        } else if(p2 != null) {
            temp.next = p2;
        }
        return dummyNode.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        // BF -  get all the value from all lists , add them to new Array List 
        // sort the arrayList 
        // again create a Linked List for the elements present in sorted array 

        // we will try to do this using merge 2 sorted Lists way 
        // everytime we will try to merge 2 sorted lists 
        // (N1+N2) - List of size N1 and list of size N2 , we will merge it and from sorted list 
        // then merge (N1+N2)  with N3 

        // start merging N1 and N2 

        int n = lists.length;
        if(n == 0) {
            return null;
        }

        ListNode head = lists[0];
        for(int i=1; i<n; i++) {
            ListNode p2 = lists[i];
            head = merge2SortedLists(head, p2);
        }
        return head;

        // TC - Explained in Leetcode - O(N*K^2) where N is max number of nodes in a Linked List 
        // SC - O(1);
    }
}
