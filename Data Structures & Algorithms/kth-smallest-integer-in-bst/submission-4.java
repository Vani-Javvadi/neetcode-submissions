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
    private int cnt = 0, ans = -1;
    private int kthSmallestElement(TreeNode root, int k) {
        // means when node is null we will come out of the current recurisve vcall right 
        // so the call will be remove from stack in the same way when we alreay had k nodes , we can skip the next recursive call by returning so next subsequent call gets removed from stack 

        if(root == null || cnt >= k) {
            return ans;
        }
        // we have to apply bottom up approach and inorder traversal , so after visting left node we have to visit root and then right - so left -> root -> right for BST 
        // so while visitn node , we will check if we have already added k values or not , if not we will add 
        
        kthSmallestElement(root.left,k);
        // visit root 
        // since we are already making the check above like if we have enough size return , so we can remove this if condition I guess
        // if(root != null && res.size() < k) {
        //     res.add(root.val);
        // }
        if(cnt == k) {
            return ans;
        }
        cnt++;
        if(cnt == k) {
            ans = root.val;
            return ans;
        }
        kthSmallestElement(root.right,k);
        return ans;
    }
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestElement(root, k);
    }
}
