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
    private void kthSmallestElement(TreeNode root, int k, List<Integer> res) {
        // means when node is null we will come out of the current recurisve vcall right 
        // so the call will be remove from stack in the same way when we alreay had k nodes , we can skip the next recursive call by returning so next subsequent call gets removed from stack 

        if(root == null || res.size() == k) {
            return ;
        }
        // we have to apply bottom up approach and inorder traversal , so after visting left node we have to visit root and then right - so left -> root -> right for BST 
        // so while visitn node , we will check if we have already added k values or not , if not we will add 
        
        kthSmallestElement(root.left,k,res);
        // visit root 
        // since we are already making the check above like if we have enough size return , so we can remove this if condition I guess
        // if(root != null && res.size() < k) {
        //     res.add(root.val);
        // }
        res.add(root.val);
        kthSmallestElement(root.right,k,res);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        kthSmallestElement(root, k, list);
        return list.get(k-1);
    }
}
