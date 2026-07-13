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

    public int maxDepth(TreeNode root) {
        // we will do it using recursion 
        // we have to return max of height of LST and height RST 
        // base condition is when there is no node , we have return 0 as there is no depth here 
        if(root == null) {
            return 0;
        }
        int depth_lst = maxDepth(root.left)+1;
        int depth_rst = maxDepth(root.right)+1;
        return Math.max(depth_lst, depth_rst);

        // TC - O(N) where N is number of nodes
        // SC - O(H) - stack space for recursion 
        // H = height of the tree (recursion stack).
        // Worst case (skewed tree): O(N)
        // Best/Average for balanced tree: O(log N)
    }
}
