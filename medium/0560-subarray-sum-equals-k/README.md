# Subarray Sum Equals K

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 
Example 1:
Input: nums = [1,1,1], k = 2
Output: 2
Example 2:
Input: nums = [1,2,3], k = 3
Output: 2

 
Constraints:


	1 <= nums.length <= 2 * 104
	-1000 <= nums[i] <= 1000
	-107 <= k <= 107

## Solution

**Language:** Java  
**Runtime:** 24 ms (beats 76.19%)  
**Memory:** 49 MB (beats 34.70%)  
**Submitted:** 2026-08-22T10:48:09.000Z  

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // base case: sum = 0 occurs once

        int prefixSum = 0, count = 0;

        for (int num : nums) {
            prefixSum += num;

            // Check if there exists a prefixSum - k
            if (prefixCount.containsKey(prefixSum - k)) {
                count += prefixCount.get(prefixSum - k);
            }

            // Update map with current prefixSum
            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/subarray-sum-equals-k/)