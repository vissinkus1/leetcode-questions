# Majority Element

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an array `nums` of size `n`, return *the majority element*.

The majority element is the element that appears more than `⌊n / 2⌋` times. You may assume that the majority element always exists in the array.

 

**Example 1:**

```
Input: nums = [3,2,3]
Output: 3

```

**Example 2:**

```
Input: nums = [2,2,1,1,1,2,2]
Output: 2

```

 

**Constraints:**

- n == nums.length
- 1 <= n <= 5 * 104
- -109 <= nums[i] <= 109
- The input is generated such that a majority element will exist in the array.

 

**Follow-up:** Could you solve the problem in linear time and in `O(1)` space?

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 71.76%)  
**Memory:** 63.5 MB (beats 5.58%)  
**Submitted:** 2026-09-22T10:24:45.734Z  

```java
class Solution {
    public int majorityElement(int[] nums) {
          // Returns the majority element.
        int candidate = 0;
        int balance = 0;

        // Cancel different values while preserving the strict majority.
        for (int value : nums) {
            // A zero balance starts a new candidate group.
            if (balance == 0) {
                candidate = value;
            }

            // Matching values add support; different values cancel support.
            if (value == candidate) {
                balance++;
            } else {
                balance--;
            }
        }

        return candidate;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/majority-element/)