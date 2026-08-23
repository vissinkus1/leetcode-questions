# Reverse String

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 
Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

 
Constraints:


	1 <= s.length <= 105
	s[i] is a printable ascii character.

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.6 MB  
**Submitted:** 2026-08-23T12:46:07.879Z  

```java
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}

    public void reverseString(char[] s) {
class Solution {

```

---

[View on LeetCode](https://leetcode.com/problems/reverse-string/)