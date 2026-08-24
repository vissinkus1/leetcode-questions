# Remove Invalid Parentheses

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.

 
Example 1:

Input: s = "()())()"
Output: ["(())()","()()()"]


Example 2:

Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]


Example 3:

Input: s = ")("
Output: [""]


 
Constraints:


	1 <= s.length <= 25
	s consists of lowercase English letters and parentheses '(' and ')'.
	There will be at most 20 parentheses in s.

## Solution

**Language:** Java  
**Runtime:** 59 ms (beats 33.45%)  
**Memory:** 47.8 MB (beats 32.32%)  
**Submitted:** 2026-08-24T07:29:56.931Z  

```java
class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process one BFS level
            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                // If valid, add it
                if (isValid(current)) {
                    result.add(current);
                    found = true;
                }

                // Don't generate next level
                // once a valid level is found
                if (found) {
                    continue;
                }

                // Remove one character
                for (int j = 0; j < current.length(); j++) {

                    // Only remove parentheses
                    if (current.charAt(j) != '(' &&
                        current.charAt(j) != ')') {
                        continue;
                    }

                    String next =
                        current.substring(0, j) +
                        current.substring(j + 1);

                    if (!visited.contains(next)) {

                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            // First valid level = minimum removals
            if (found) {
                break;
            }
        }

        return result;
    }

    private boolean isValid(String s) {

        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                balance++;
            }
            else if (ch == ')') {
                balance--;
            }

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/remove-invalid-parentheses/)