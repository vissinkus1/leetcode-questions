# Palindrome Partitioning

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

 
Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:
Input: s = "a"
Output: [["a"]]

 
Constraints:


	1 <= s.length <= 16
	s contains only lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 7 ms (beats 96.94%)  
**Memory:** 65.3 MB (beats 40.74%)  
**Submitted:** 2026-08-22T10:13:16.257Z  

```java
class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
        String s,
        int start,
        List<String> path,
        List<List<String>> result
    ) {

        // We reached the end of the string
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Try every possible substring
        for (int end = start; end < s.length(); end++) {

            // Take substring
            String part = s.substring(start, end + 1);

            // Only continue if it is palindrome
            if (isPalindrome(part)) {

                // Choose
                path.add(part);

                // Explore
                backtrack(s, end + 1, path, result);

                // Undo
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/palindrome-partitioning/)