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
    private int height(TreeNode root) {
        // check height 

        if(root == null) {
            return 0; 
        }
        int lst = height(root.left)+1;
        int rst = height(root.right)+1;
        return Math.max(lst, rst);
    }
    public boolean isBalanced(TreeNode root) {
        // we have traverse tree 
        // I will apply preorder traversal , then I will take each node and find its lst height and rst heigt 
        // and check if they are not differing by 1 , then I will return false 
        // if at the end like after traversing all nodes , we did not encounter any sub node  with height difference > 1 between LST and RST 
        // then we can return true 

        // applying traversal 
        if(root == null){
            return true;
        }

        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode currNode = st.pop();
            int heightdiff = Math.abs(height(currNode.left) - height(currNode.right));
            if(heightdiff > 1) {
                return false;
            }
            if(currNode.right != null) {
                st.push(currNode.right);
            }
            if(currNode.left != null) {
                st.push(currNode.left);
            }
        }
        return true;
    }
}
