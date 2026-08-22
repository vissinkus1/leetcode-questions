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
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validate(TreeNode node, long min, long max) {

        if (node == null) {
            return true;
        }

        // Node must be inside the valid range
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Left subtree
        boolean left = validate(node.left, min, node.val);

        // Right subtree
        boolean right = validate(node.right, node.val, max);

        return left && right;
    }
}