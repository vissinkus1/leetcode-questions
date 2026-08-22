# Binary Tree Level Order Traversal

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 
Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]


Example 2:

Input: root = [1]
Output: [[1]]


Example 3:

Input: root = []
Output: []


 
Constraints:


	The number of nodes in the tree is in the range [0, 2000].
	-1000 <= Node.val <= 1000

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 95.81%)  
**Memory:** 46.7 MB (beats 62.11%)  
**Submitted:** 2026-08-22T10:39:35.546Z  

```java
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
          List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            
            int len = q.size();
            
            List<Integer> sa = new ArrayList<>();
            
            for(int i = 0; i < len; i++) {
                
                TreeNode curr = q.remove();
                
                sa.add(curr.val);
                
                if(curr.left != null) {
                    q.add(curr.left);
                }
                
                if(curr.right != null) {
                    q.add(curr.right);
                }
                
                
            }
            
            ans.add(sa);
            
        }
        
        return ans;
        
        
        
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/binary-tree-level-order-traversal/)