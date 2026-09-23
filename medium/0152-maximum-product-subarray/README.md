# Maximum Product Subarray

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array `nums`, find a subarray that has the largest product, and return *the product*.

The test cases are generated so that the answer will fit in a **32-bit** integer.

**Note** that the product of an array with a single element is the value of that element.

 

**Example 1:**

```
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

```

**Example 2:**

```
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

```

 

**Constraints:**

- 1 <= nums.length <= 2 * 104
- -10 <= nums[i] <= 10
- The product of any subarray of nums is guaranteed to fit in a 32-bit integer.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 71.64%)  
**Memory:** 47.3 MB (beats 53.04%)  
**Submitted:** 2026-09-23T07:23:10.603Z  

```java
class Solution {
    public int maxProduct(int[] nums) {
        // Initialize with the first element
        int currentMax = nums[0];
        int currentMin = nums[0];
        int maxProduct = nums[0];

        // Iterate through the array starting from index 1
        for (int i = 1; i < nums.length; i++) {
            int temp = currentMax;

            // Update currentMax and currentMin
            currentMax = Math.max(nums[i], Math.max(nums[i] * currentMax, nums[i] * currentMin));
            currentMin = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * currentMin));

            // Update global maxProduct
            maxProduct = Math.max(maxProduct, currentMax);
        }

        return maxProduct;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/maximum-product-subarray/)