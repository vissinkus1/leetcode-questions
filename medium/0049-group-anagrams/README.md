# Group Anagrams

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 
Example 1:


Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:


	There is no string in strs that can be rearranged to form "bat".
	The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
	The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.



Example 2:


Input: strs = [""]

Output: [[""]]


Example 3:


Input: strs = ["a"]

Output: [["a"]]


 
Constraints:


	1 <= strs.length <= 104
	0 <= strs[i].length <= 100
	strs[i] consists of lowercase English letters.

## Solution

**Language:** Java  
**Runtime:** 7 ms (beats 71.80%)  
**Memory:** 49.7 MB (beats 59.83%)  
**Submitted:** 2026-09-13T13:30:03.224Z  

```java
import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/group-anagrams/)