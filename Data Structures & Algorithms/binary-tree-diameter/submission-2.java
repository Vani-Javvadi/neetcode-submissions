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
    private int maxHeightOfTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int heightLst = maxHeightOfTree(root.left)+1;
        int heightRst = maxHeightOfTree(root.right)+1;
        return Math.max(heightLst, heightRst);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        // we know the maximum path will always pass through root 
        // so the maximum that we can reach via root is maximum height of its LST and maximum height of its RST 
        if(root == null) {
            return 0;
        }
        Stack<TreeNode> st = new Stack<>();
        int path = 0;
        st.push(root);
        while(!st.isEmpty()) {
            // pop the top value and find the path maximum path we can form 
            // the maximum path for a node is maximum height of its LST + RST 
            TreeNode currNode = st.pop();
            int pathOfNode = maxHeightOfTree(currNode.left)+maxHeightOfTree(currNode.right);
            path = Math.max(path, pathOfNode);
            if(currNode.right != null) {
                st.push(currNode.right);
            }
            if(currNode.left != null) {
                st.push(currNode.left);
            }
        }
        return path;
    }
}
