# Maximum XOR of Two Numbers in an Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

 
Example 1:

Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.


Example 2:

Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127


 
Constraints:


	1 <= nums.length <= 2 * 105
	0 <= nums[i] <= 231 - 1

## Solution

**Language:** Java  
**Runtime:** 919 ms (beats 37.32%)  
**Memory:** 208.9 MB (beats 35.89%)  
**Submitted:** 2026-08-24T07:24:20.411Z  

```java
class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    public int findMaximumXOR(int[] nums) {

        TrieNode root = new TrieNode();

        // Insert all numbers
        for (int num : nums) {
            insert(root, num);
        }

        int maxXor = 0;

        // Find best XOR for every number
        for (int num : nums) {
            maxXor = Math.max(maxXor, getMaxXor(root, num));
        }

        return maxXor;
    }

    private void insert(TrieNode root, int num) {

        TrieNode node = root;

        // 30 -> 0 because nums[i] <= 2^31 - 1
        for (int i = 30; i >= 0; i--) {

            int bit = (num >> i) & 1;

            if (node.child[bit] == null) {
                node.child[bit] = new TrieNode();
            }

            node = node.child[bit];
        }
    }

    private int getMaxXor(TrieNode root, int num) {

        TrieNode node = root;
        int result = 0;

        for (int i = 30; i >= 0; i--) {

            int bit = (num >> i) & 1;

            int opposite = bit ^ 1;

            // Prefer opposite bit
            if (node.child[opposite] != null) {

                result |= (1 << i);
                node = node.child[opposite];

            } else {

                node = node.child[bit];
            }
        }

        return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/)