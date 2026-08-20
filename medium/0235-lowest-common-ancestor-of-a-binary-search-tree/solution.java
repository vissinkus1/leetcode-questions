/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q) {

        while (root != null) {

            if (p.val < root.val && q.val < root.val) {

                // Both nodes are on the left
                root = root.left;

            } 
            else if (p.val > root.val && q.val > root.val) {

                // Both nodes are on the right
                root = root.right;

            } 
            else {

                // Split point → LCA
                return root;
            }
        }

        return null;
    }
}