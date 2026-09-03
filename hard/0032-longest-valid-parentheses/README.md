# Longest Valid Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.

 
Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".


Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".


Example 3:

Input: s = ""
Output: 0


 
Constraints:


	0 <= s.length <= 3 * 104
	s[i] is '(', or ')'.

## Solution

**Language:** Java  
**Runtime:** 2 ms (beats 96.86%)  
**Memory:** 45.3 MB (beats 85.48%)  
**Submitted:** 2026-09-03T06:31:07.102Z  

```java
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int maxLen = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1] - 2 >= 0) ? dp[i - dp[i - 1] - 2] : 0);
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/longest-valid-parentheses/)