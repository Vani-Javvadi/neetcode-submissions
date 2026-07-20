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
        else if(res.size() == level) {
            res.add(root.val);
        }
        rightView(root.right, level + 1, res);
        rightView(root.left, level + 1, res);
        return res;
    }
    public List<Integer> rightSideView(TreeNode root) {
        // optimizing the prev solution , by removing set to store already traversed levels 
        // the intution is when res array size equals to level , means that is the first node we are considering in that level 
        // as we move from left to right , if right node is there we will add increment the level 
        // so when we add size and level increase in the same way 
        // so we can make use of res side to decide whether we have to consider the node or not 
        // take an example and try , to understand better 

        List<Integer> list = new ArrayList<>();
        return rightView(root, 0, list);

    }
}
