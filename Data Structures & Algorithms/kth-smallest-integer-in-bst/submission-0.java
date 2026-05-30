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
    int K;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        K = k;
        inOrder(root);
        return res;
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        K-=1;
        if (K == 0) {
            res = root.val;
        }
        inOrder(root.right);
    }
}
