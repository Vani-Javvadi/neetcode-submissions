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
        kthSmallestElement(root.left,k,res);
        // visit root 
        if(root != null && res.size() < k) {
            res.add(root.val);
        }
        kthSmallestElement(root.right,k,res);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        kthSmallestElement(root, k, list);
        return list.get(k-1);
    }
}
