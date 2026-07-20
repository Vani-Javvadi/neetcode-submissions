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
    private List<Integer> rightView(TreeNode root, Set<Integer> levels, int level, List<Integer> res) {
        if(root == null) {
            return res;
        }
        else if(!levels.contains(level)) {
            res.add(root.val);
            levels.add(level);
        }
        rightView(root.right, levels, level + 1, res);
        rightView(root.left, levels, level + 1, res);
        return res;
    }
    public List<Integer> rightSideView(TreeNode root) {
        // we have to do traverse right to left of node 
        // so if the current node is first node visited from that left , then add 
        // so we will consider a set, while adding first node of the level to result, we will also add the level to the set 
        // so that when we encounter a node in same level again , we can check in set for level 
        // if there will not add to res 
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        return rightView(root, set, 0, list);

    }
}
