/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // 3 steps 
        // step1 - insert a new node between current node and next one 
        // connect the random pointers for the new node 
        // remove the connection between new node and old 
        // I wrote the detailed explaination in notes refer that 

        if(head == null) {
            return null;
        }

        // Step 1 - created new copied node and insert them between current node and its next one 
        // like 3 copied node to be inserted between 3 and 7 in original LL 
        Node temp = head;
        while(temp != null) {
            Node createdNode = new Node(temp.val);

            createdNode.next = temp.next;
            temp.next = createdNode;
            temp = temp.next.next;
        }

        temp = head;
        while(temp != null) {
            if(temp.random != null) {
                temp.next.random = temp.random.next;
            } else {
                // when temp.random is null say 3.random pointing to null in original LL 
                temp.next.random = null;
            }
            temp = temp.next.next;
        }

        Node dummyNode = new Node(-1);
        dummyNode.next = head.next;
        temp = head;


        // remove the connection between original and copied and 
        // make connections between original LL next pointer and as well in copied List next pointers
        // like original LL original_3.next = original_7 
        // copied_3.next = copied_7

        while(temp != null) {
            Node copiedNode = temp.next;
            temp.next = copiedNode.next;
            if(copiedNode.next != null) {
                copiedNode.next = temp.next.next;
            }
            temp = temp.next; 
        }

        return dummyNode.next;

    }

}