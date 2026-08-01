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
    private boolean checkValidBST(TreeNode root, int leftMin, int rightMax) {
        if (root == null) {
            return true;
        }
        // If the current node's value is not within this range,
        // then it is not a valid BST.
        if((root.val <= leftMin || root.val >= rightMax)) {
            return false;
        }
        /// Every time we recurse to the LEFT subtree,
        // we update the upper (max) bound with the current root's value,
        // because every node in the left subtree must be smaller than the current root.
        //
        // Range becomes:
        // (leftMin, root.val)
        return (checkValidBST(root.left, leftMin, root.val) 
        && checkValidBST(root.right, root.val, rightMax));
        // Every time we recurse to the RIGHT subtree,
        // we update the lower (min) bound with the current root's value,
        // because every node in the right subtree must be greater than the current root.
        //
        // Range becomes:
        // (root.val, rightMax)
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        // For every node, we have to check whether its value falls within the valid range
        // inherited from its ancestors.

        // Initially:
// Left subtree range  -> (-∞, root.val)
// Right subtree range -> (root.val, +∞)
        return checkValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
