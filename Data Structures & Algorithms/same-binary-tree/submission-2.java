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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // we will travrse the both trees at the same time , if nodes values are not eqial , we will return false 
        // at the end if all nodes are equal we will return true 

        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(p);
        st2.push(q);
        while(!st1.isEmpty() && !st2.isEmpty()) {
            TreeNode curr_p = st1.pop();
            TreeNode curr_q = st2.pop();
            
            if(curr_p.val != curr_q.val) {
                return false;
            } 
            if((curr_p.right == null && curr_q.right != null) || (curr_p.right != null && curr_q.right == null) || (curr_p.left != null && curr_q.left == null) || (curr_p.left == null && curr_q.left != null)) {
                return false;
            }

            if(curr_p.right != null) {
                st1.push(curr_p.right);
            }
            if(curr_q.right != null) {
                st2.push(curr_q.right);
            }
            if(curr_p.left != null) {
                st1.push(curr_p.left);
            }
            if(curr_q.left != null) {
                st2.push(curr_q.left);
            }
        }

        // if any one of them is not empty means nodes are still there , there are not same trees 
        if(!st1.isEmpty() || !st2.isEmpty()) {
            return false;
        } 
        return true;

    }
}
