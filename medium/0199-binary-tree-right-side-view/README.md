# Binary Tree Right Side View

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 
Example 1:


Input: root = [1,2,3,null,5,null,4]

Output: [1,3,4]

Explanation:




Example 2:


Input: root = [1,2,3,4,null,null,null,5]

Output: [1,3,4,5]

Explanation:




Example 3:


Input: root = [1,null,3]

Output: [1,3]


Example 4:


Input: root = []

Output: []


 
Constraints:


	The number of nodes in the tree is in the range [0, 100].
	-100 <= Node.val <= 100

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 43.5 MB (beats 84.89%)  
**Submitted:** 2026-08-22T10:39:57.030Z  

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
```

---

[View on LeetCode](https://leetcode.com/problems/binary-tree-right-side-view/)