# Word Search

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 
Example 1:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true


Example 2:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true


Example 3:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false


 
Constraints:


	m == board.length
	n = board[i].length
	1 <= m, n <= 6
	1 <= word.length <= 15
	board and word consists of only lowercase and uppercase English letters.


 
Follow up: Could you use search pruning to make your solution faster with a larger board?

## Solution

**Language:** Java  
**Runtime:** 128 ms (beats 87.28%)  
**Memory:** 43 MB (beats 59.84%)  
**Submitted:** 2026-08-22T10:28:49.836Z  

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(index)) return false;

        char temp = board[i][j];
        board[i][j] = '#'; // mark visited

        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);

        board[i][j] = temp; // backtrack
        return found;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/word-search/)