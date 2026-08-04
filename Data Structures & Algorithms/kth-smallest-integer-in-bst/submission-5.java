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

        if(root == null || cnt >= k) {
            return ans;
        }
        
        kthSmallestElement(root.left,k);
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
