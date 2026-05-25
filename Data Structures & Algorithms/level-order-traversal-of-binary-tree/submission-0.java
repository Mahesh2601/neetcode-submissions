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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        while (!q.isEmpty()) {
            int s = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < s; i++) {
                TreeNode z = q.pollFirst();
                l.add(z.val);
                if (z.left != null) q.offerLast(z.left);
                if (z.right != null) q.offerLast(z.right);
            }
            res.add(l);
        }
        return res;
    }
}
