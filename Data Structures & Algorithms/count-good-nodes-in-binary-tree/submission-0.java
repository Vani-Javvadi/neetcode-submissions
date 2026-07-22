/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private int goodNodesCount(TreeNode node,  int prevNodeVal) {
        int current = 0;
        if(node == null) {
            return 0;
        }
        if(node.val >= prevNodeVal) {
            prevNodeVal = node.val;
            current = 1;
        }
        int cnt1 = goodNodesCount(node.left, prevNodeVal);
        int cnt2 = goodNodesCount(node.right, prevNodeVal);
        return cnt1+cnt2+current;
    }
    public int goodNodes(TreeNode root) {
        // we will apply top down approach here 
        // because we need current node value , because cur node will be path for its child nodes 
        // so if curr node value is greater than its child node means , the child node cannot be considered as good one ,
        // because in its path there is already a node which is greater than that.
        // so we nned to have curr node value , to check if next nodes (child) need to considered or not 
        // so the currenode have enough info to make decision 

        if(root == null) {
            return 0;
        }
        return goodNodesCount(root, -200);
    }
}
