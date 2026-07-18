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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = q.size();
            for(int i=1; i<=n; i++) {
                TreeNode currNode = q.poll();
                list.add(currNode.val);
                if(currNode.left != null) {
                    q.offer(currNode.left);
                } 
                if(currNode.right != null) {
                    q.offer(currNode.right);
                }
            }
            if(list.size() != 0) {
                res.add(list);
            }
         }
         return res;
    }
}
