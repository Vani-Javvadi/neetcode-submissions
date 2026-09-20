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
    // as we know Pre Order is Root -> left -> right 
    // Inorder is - Left -> root -> right 
    // we will take this as our input and build Tree 
    HashMap<Integer, Integer> inOrderPos = new HashMap<>();
    private TreeNode buildBT(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE) {
        if(preS > preE || inS > inE) {
            return null;
        }
        // root node will be the first value in preOrderArray 
        TreeNode root = new TreeNode(preorder[preS]);
        // build LST , to do that we should know the position of root node in Inorder array 
        // so that all values left to it will be LST and right to it will be RST 
        int inPos = inOrderPos.get(preorder[preS]);
        int numOfLeftNodes = inPos - inS;
        root.left = buildBT(preorder, preS+1, preS+numOfLeftNodes, inorder, inS, inPos-1);
        // build RST 
        root.right = buildBT(preorder, preS+numOfLeftNodes+1, preE, inorder, inPos+1, inE);
        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for(int i=0; i<n; i++) {
            inOrderPos.put(inorder[i], i);
        }
        return buildBT(preorder, 0, n-1, inorder, 0, n-1);
    }

//     Say:

// "Each node is processed once, and because the inorder position is obtained from the HashMap in O(1), the total time complexity is O(n)."

// For space:

// "The HashMap takes O(n), and the recursion stack takes O(h), where h is the height of the tree. Therefore the auxiliary space is O(n) in the worst case."

// That's more precise than simply saying "because it is recursive, space is O(n)." Recursion itself doesn't automatically mean O(n); it depends on the recursion depth.
}
