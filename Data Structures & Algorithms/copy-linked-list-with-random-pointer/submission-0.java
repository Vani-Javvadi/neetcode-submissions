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
        Node dummyNode = new Node(-1);
        Node deepCopyList = dummyNode;
        // we will use map to track old node and new node 
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        Node node = temp;
        while(temp != null) {
            if(map.containsKey(temp)) {
                node = map.get(temp);
                Node randomPointer = temp.random;
                checkRandomNode(node, map, randomPointer); 
            }
            // not in map means , we have to create a node as it has occurred firsttime  
            else {
                node = new Node(temp.val);
                map.put(temp, node);
                // if there is a random value present in current node random pointer 
                // check if random pointer node was already created , if not created create and attach new node at random, if already exist attach the same node in random pointer 
                Node randomPointer = temp.random;
                checkRandomNode(node, map, randomPointer);
            }
            dummyNode.next = node;
            temp = temp.next;
            dummyNode = dummyNode.next;
        }
        return deepCopyList.next;
    }

    private void checkRandomNode(Node node, Map<Node, Node> map, Node tempRandom) {
        // if there is a random value present in current node random pointer 
        // check if random pointer node was already created , if not created create and attach new node at random, if already exist attach the same node in random pointer 
        if(tempRandom != null) {
            if(map.containsKey(tempRandom)) {
                node.random = map.get(tempRandom);
            } else {
                // create a radom pointer and attach it 
                Node newRandomNode = new Node(tempRandom.val);
                node.random = newRandomNode;
                map.put(tempRandom, newRandomNode);
            }
        }
    }

}