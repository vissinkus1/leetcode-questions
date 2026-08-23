# Max Consecutive Ones

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a binary array nums, return the maximum number of consecutive 1's in the array.

 
Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.


Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2


 
Constraints:


	1 <= nums.length <= 105
	nums[i] is either 0 or 1.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 98.38%)  
**Memory:** 52.4 MB (beats 84.61%)  
**Submitted:** 2026-08-23T09:38:18.037Z  

```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
       int  max=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }
            else {
                max=Math.max(max,count);
                count=0;
            }


            }
             return Math.max(max,count);
        }
        
    }

```

---

[View on LeetCode](https://leetcode.com/problems/max-consecutive-ones/)