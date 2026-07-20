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
        // we have to do traverse right to left of node 
        // so if the current node is first node visited from that left , then add 
        // so we will consider a set, while adding first node of the level to result, we will also add the level to the set 
        // so that when we encounter a node in same level again , we can check in set for level 
        // if there will not add to res 
        // we have to apply top down  approach because when we move from right , the current node can be answer , so we can check and add while travesing itself 
        // means while we are at current node itsled we can decide to consider or not , means we don't need to wait for back tracking 

        // optimizing the prev solution , by removing set to store already traversed levels 
        // the intution is when res array size equals to level , means that is the first node we are considering in that level 
        // as we move from left to right , if right node is there we will add increment the level 
        // so when we add size and level increase in the same way 
        // so we can make use of res side to decide whether we have to consider the node or not 
        // take an example and try , to understand better 

        return rightView(root, 0, new ArrayList<>());

    }
}
