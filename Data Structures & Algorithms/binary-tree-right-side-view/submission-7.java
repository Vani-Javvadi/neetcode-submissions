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
    private List<Integer> rightView(TreeNode root, int level, List<Integer> res) {
        if(root == null) {
            return res;
        }

        if(res.size() == level) {
            res.add(root.val);
        }
        // go to right node first as we have view from right side 
        rightView(root.right, level+1, res);
        rightView(root.left, level+1, res);
        return res;

    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return rightView(root, 0, res);
    }
}
