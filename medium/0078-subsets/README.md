# Subsets

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 
Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]


Example 2:

Input: nums = [0]
Output: [[],[0]]


 
Constraints:


	1 <= nums.length <= 10
	-10 <= nums[i] <= 10
	All the numbers of nums are unique.

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 86.40%)  
**Memory:** 44.5 MB (beats 7.00%)  
**Submitted:** 2026-08-22T10:29:39.777Z  

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Choice 1: Exclude nums[index]
        backtrack(nums, index + 1, current, result);

        // Choice 2: Include nums[index]
        current.add(nums[index]);
        backtrack(nums, index + 1, current, result);
        current.remove(current.size() - 1); // backtrack
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/subsets/)