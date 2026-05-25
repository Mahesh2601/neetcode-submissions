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
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, -101);
    }

    public int countGoodNodes(TreeNode root, int prevLarge) {
        if (root == null) return 0;
        int c = 0;
        if (root.val >= prevLarge) {
            prevLarge = root.val;
            c = 1;
        }
        return c + countGoodNodes(root.left, prevLarge)
                    + countGoodNodes(root.right, prevLarge);
    }
}
