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
    List<Integer> ans;
    int globalLvl = 0;


    public void rightView(TreeNode root, int currLvl,  List<Integer> ans) {

        if(root == null) return ;

        if(currLvl == globalLvl) {
            ans.add(root.val);
            globalLvl++;
        }

        rightView(root.right, currLvl + 1, ans);
        rightView(root.left, currLvl + 1, ans);


    }
    public List<Integer> rightSideView(TreeNode root) {

        ans = new ArrayList<Integer>();

        rightView(root, 0, ans);

        return ans;
        
    }
}