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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // we have to do post order traversal 
        // then only we can visit its child and then visit root 
        // so if p and q are childs and we found them , when we reach its parent we can return that as common ancestor 

        if(root == null || root.val == p.val || root.val == q.val) {
            return root; 
        }

        
        TreeNode left = lowestCommonAncestor(root.left, p, q) ;
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }
        // if p,q are left skwed , one of them will be LCA 
        if(left != null) {
            return left;
        }
        // if p,q are in right skewed tree, one of them will be LCA 
        if (right != null) {
            return right;
        }

        return null;
    }
}
