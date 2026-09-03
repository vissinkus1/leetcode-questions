# Word Search II

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 
Example 1:

Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]


Example 2:

Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []


 
Constraints:


	m == board.length
	n == board[i].length
	1 <= m, n <= 12
	board[i][j] is a lowercase English letter.
	1 <= words.length <= 3 * 104
	1 <= words[i].length <= 10
	words[i] consists of lowercase English letters.
	All the strings of words are unique.

## Solution

**Language:** Java  
**Runtime:** 153 ms (beats 65.73%)  
**Memory:** 47.1 MB (beats 41.09%)  
**Submitted:** 2026-09-03T06:18:45.199Z  

```java
class Solution {

    class TrieNode {

        TrieNode[] children = new TrieNode[26];

        String word;
    }

    private TrieNode root = new TrieNode();

    private List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words) {
            insert(word);
        }

        int rows = board.length;
        int cols = board[0].length;

        // Start DFS from every cell
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                dfs(board, r, c, root);
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.word = word;
    }

    private void dfs(
            char[][] board,
            int row,
            int col,
            TrieNode node) {

        // Boundary check
        if (row < 0 ||
            row >= board.length ||
            col < 0 ||
            col >= board[0].length) {

            return;
        }

        // Already visited
        if (board[row][col] == '#') {
            return;
        }

        char ch = board[row][col];

        int index = ch - 'a';

        // Character is not a Trie prefix
        if (node.children[index] == null) {
            return;
        }

        TrieNode next = node.children[index];

        // Found a complete word
        if (next.word != null) {

            result.add(next.word);

            // Avoid adding duplicate word
            next.word = null;
        }

        // Mark current cell as visited
        board[row][col] = '#';

        // Explore four directions
        dfs(board, row - 1, col, next); // up
        dfs(board, row + 1, col, next); // down
        dfs(board, row, col - 1, next); // left
        dfs(board, row, col + 1, next); // right

        // Backtrack
        board[row][col] = ch;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/word-search-ii/)