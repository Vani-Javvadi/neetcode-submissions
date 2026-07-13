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
        // we have to return maxi of height of LST and height RST 
        // base condition is when there is no node , we have return 0 as there is no depth here 
        if(root == null) {
            return 0;
        }
        int height_lst = maxDepth(root.left)+1;
        int height_rst = maxDepth(root.right)+1;
        return Math.max(height_lst, height_rst);
    }
}
