# Smallest Range II

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer array nums and an integer k.

For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.

The score of nums is the difference between the maximum and minimum elements in nums.

Return the minimum score of nums after changing the values at each index.

 
Example 1:

Input: nums = [1], k = 0
Output: 0
Explanation: The score is max(nums) - min(nums) = 1 - 1 = 0.


Example 2:

Input: nums = [0,10], k = 2
Output: 6
Explanation: Change nums to be [2, 8]. The score is max(nums) - min(nums) = 8 - 2 = 6.


Example 3:

Input: nums = [1,3,6], k = 3
Output: 3
Explanation: Change nums to be [4, 6, 3]. The score is max(nums) - min(nums) = 6 - 3 = 3.


 
Constraints:


	1 <= nums.length <= 104
	0 <= nums[i] <= 104
	0 <= k <= 104

## Solution

**Language:** Java  
**Runtime:** 15 ms (beats 94.97%)  
**Memory:** 47.3 MB (beats 45.81%)  
**Submitted:** 2026-09-01T08:34:07.668Z  

```java
class Solution {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        java.util.Arrays.sort(nums);
        
        int ans = nums[n - 1] - nums[0];
        
        for (int i = 1; i < n; i++) {
            int minVal = Math.min(nums[0] + k, nums[i] - k);
            int maxVal = Math.max(nums[i - 1] + k, nums[n - 1] - k);
            ans = Math.min(ans, maxVal - minVal);
        }
        
        return ans;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/smallest-range-ii/)