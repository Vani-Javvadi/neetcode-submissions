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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        Queue<TreeNode> q = new ArrayDeque<>();
        // level order Traversal 
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.left != null) {
                q.offer(node.left);
                sb.append(node.left.val).append(",");
            } else {
                sb.append("#,");
            }
            if(node.right != null) {
                q.offer(node.right);
                 sb.append(node.right.val).append(",");
            } else {
                sb.append("#,");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null){
            return null;
        }
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q  = new ArrayDeque<>();
        q.offer(root);
        int i=1;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode left = null;
            if(!nodes[i].equals("#")) {
                left = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(left);
            }
            i++;
            TreeNode right = null;
            if(!nodes[i].equals("#")) {
                right = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(right);
            }
            node.left = left;
            node.right = right;
            i++;
        }
        return root;
    }
}
