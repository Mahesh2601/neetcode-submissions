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
        if (root == null) return null;
        TreeNode x = lowestCommonAncestor(root.left, p, q);
        if (x != null) return x;
        TreeNode y = lowestCommonAncestor(root.right, p, q);
        if (y != null) return y;
        
        if (containsInIt(root, p) && containsInIt(root, q)) return root;
        return null;
    }

    public boolean containsInIt(TreeNode root, TreeNode x) {
        if (root == null) return false;
        return (root.val == x.val) || (root.val > x.val && containsInIt(root.left, x)) ||
            (root.val < x.val && containsInIt(root.right, x));
    }
}
