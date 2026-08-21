# Shortest Unsorted Continuous Subarray

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.

Return the shortest such subarray and output its length.

 
Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.


Example 2:

Input: nums = [1,2,3,4]
Output: 0


Example 3:

Input: nums = [1]
Output: 0


 
Constraints:


	1 <= nums.length <= 104
	-105 <= nums[i] <= 105


 
Follow up: Can you solve it in O(n) time complexity?

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 86.99%)  
**Memory:** 46.9 MB (beats 92.97%)  
**Submitted:** 2026-08-21T17:43:58.700Z  

```java
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;

        // Find first element out of order from left
        while (left < n - 1 && nums[left] <= nums[left + 1]) {
            left++;
        }

        // Already sorted
        if (left == n - 1) return 0;

        // Find first element out of order from right
        while (right > 0 && nums[right] >= nums[right - 1]) {
            right--;
        }

        // Find min and max in the unsorted subarray
        int subarrayMin = Integer.MAX_VALUE;
        int subarrayMax = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            subarrayMin = Math.min(subarrayMin, nums[i]);
            subarrayMax = Math.max(subarrayMax, nums[i]);
        }

        // Expand left boundary
        while (left > 0 && nums[left - 1] > subarrayMin) {
            left--;
        }

        // Expand right boundary
        while (right < n - 1 && nums[right + 1] < subarrayMax) {
            right++;
        }

        return right - left + 1;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/shortest-unsorted-continuous-subarray/)