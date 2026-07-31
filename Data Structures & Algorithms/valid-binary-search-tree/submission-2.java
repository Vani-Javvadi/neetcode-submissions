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
        System.out.println(root.val + " " + leftMin + " " + rightMax);
        if((root.val <= leftMin || root.val >= rightMax)) {
            System.out.println("not a BST");
            return false;
        }
        return (checkValidBST(root.left, leftMin, root.val) && checkValidBST(root.right, root.val, rightMax));
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(checkValidBST(root.left, Integer.MIN_VALUE, root.val) && checkValidBST(root.right, root.val, Integer.MAX_VALUE)) {
            return true;
        }
        return false;
    }
}
