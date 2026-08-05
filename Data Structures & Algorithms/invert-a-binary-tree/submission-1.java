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
    // there is queue solution as well , I wrote in Leetcode 
    public TreeNode invertTree(TreeNode root) {
        // recursive solution 
        // we will take each node go to its left and right and then try to swap them 
        // once we have iverted the nodes of rst and lst , then we invert the root left and right node 

        // base condition is when we encouter null , return null 
        if(root == null) {
            return null;
        }
        // call left node 
        TreeNode left = invertTree(root.left); // Go to the left child, invert its subtree, and return that node.
        TreeNode right = invertTree(root.right); // Go to the right child, invert its subtree, and return that node.
        
        // then swap once we have left and right 
        TreeNode temp = left;
        // We have to attach the swapped nodes back to root because left and right are just reference variables
        root.left = right;
        root.right = temp;
        return root; 
     /*

        * Why return root?
        * - After inverting the current node's children, return this node.
        * - Its parent receives this returned node as its left or right child.
        * - Example: if node 2 is the left child of node 1, after inverting node 2's
        *   subtree, we return node 2 so node 1 can continue building the inverted tree.
 */ 
    }
}
