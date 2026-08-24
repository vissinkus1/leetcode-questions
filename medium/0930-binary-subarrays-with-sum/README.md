# Binary Subarrays With Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array.

 
Example 1:

Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Explanation: The 4 subarrays are bolded and underlined below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]


Example 2:

Input: nums = [0,0,0,0,0], goal = 0
Output: 15


 
Constraints:


	1 <= nums.length <= 3 * 104
	nums[i] is either 0 or 1.
	0 <= goal <= nums.length

## Solution

**Language:** Java  
**Runtime:** 22 ms (beats 43.71%)  
**Memory:** 50.5 MB (beats 90.93%)  
**Submitted:** 2026-08-24T11:22:06.100Z  

```java
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 exists once before starting
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {

            sum += num;

            int required = sum - goal;

            // Count previous prefix sums
            count += map.getOrDefault(required, 0);

            // Store current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/binary-subarrays-with-sum/)