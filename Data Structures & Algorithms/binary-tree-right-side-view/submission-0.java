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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s-1; i++) {
                TreeNode x = q.pollFirst();
                if (x.left != null) q.offerLast(x.left);
                if (x.right != null) q.offerLast(x.right);
            }
            TreeNode x = q.pollFirst();
            if (x.left != null) q.offerLast(x.left);
            if (x.right != null) q.offerLast(x.right);
            res.add(x.val);
        }
        return res;
    }
}
