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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isBST(Integer.MIN_VALUE, root, Integer.MAX_VALUE);
    }

    public boolean isBST(int left, TreeNode root, int right) {
        if (root == null) return true;
        return left < root.val && root.val < right 
            && isBST(left, root.left, root.val)
            && isBST(root.val, root.right, right);
    }
}
