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
        // BF -  get all the value from all lists , add them to new Array List 
        // sort the arrayList 
        // again create a Linked List for the elements present in sorted array 

        // we will try to do this using merge 2 sorted Lists way 
        // everytime we will try to merge 2 sorted lists 
        // (N1+N2) - List of size N1 and list of size N2 , we will merge it and from sorted list 
        // then merge (N1+N2)  with N3 

        // start merging N1 and N2 

        // optimal Solution - using Min heap 
        // we will create a min heap and insert all k lists first nodes into min heap 
        // pop the min element from heap , after poping inser its next node in LL 
        // attach the poped element to dummyNode List 
        // so in heap (PQ) we store the value and Node as Pair , Pair<int, Node> 
        int n = lists.length;
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        // define PQ 
        PriorityQueue<Pair<Integer, ListNode>> pq = new PriorityQueue<>((a,b) -> a.getKey() - b.getKey());
        // O(k*logK) - to heapify while inserting K Nodes 
        for(int i=0; i<n; i++) {
            // inser all the first element into heap , like a pair val and node 
            pq.offer(new Pair<>(lists[i].val, lists[i])); 
        }
        while(!pq.isEmpty()) {
            // pop the min element which will be at peek in minheap and inser its next node 
            ListNode minElement = pq.poll().getValue();
            ListNode nextElement = minElement.next;
            if(nextElement != null) {
                pq.offer(new Pair<>(nextElement.val, nextElement));
            }
            // add the min to LinkedList 
            temp.next = minElement;
            temp = temp.next;
        }
        return dummyNode.next; 

        // TC - O(K*logK) - insert 
        //    - O((N*K)*logK) - we will process N*K elements totally 
        // so for each element when we pop and insert there will be heapify operation which take 2*O(logK)
        // FInal TC -  O(K*logK) + O((N*K)*logK)

        // SC - O(K) - min heap
    }
}
