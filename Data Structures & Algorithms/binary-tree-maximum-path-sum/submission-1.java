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
    private int maxSum = -1001;
    private int maxPathSumInBT(TreeNode root) {
        if(root == null) {
                return 0;
        }
        int leftSum = maxPathSumInBT(root.left);
        int rightSum = maxPathSumInBT(root.right);

        int childSum = Math.max((leftSum+root.val) , (rightSum+root.val));
        // in a path Ihave to consider either left or right not both , 
        // if both left and right path giving lesser sum than current root value na then take only root 
        int currentPathSum = Math.max(childSum, root.val); 
        int currentNodeSum = root.val+leftSum+rightSum;
        maxSum = Math.max(Math.max(currentPathSum, currentNodeSum), maxSum);
        return currentPathSum;
    }
    public int maxPathSum(TreeNode root) {
        int rootNodeSum = maxPathSumInBT(root);
        return maxSum;
    }
}
