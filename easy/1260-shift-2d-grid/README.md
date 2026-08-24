# Shift 2D Grid

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:


	Element at grid[i][j] moves to grid[i][j + 1].
	Element at grid[i][n - 1] moves to grid[i + 1][0].
	Element at grid[m - 1][n - 1] moves to grid[0][0].


Return the 2D grid after applying shift operation k times.

 
Example 1:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]


Example 2:

Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]


Example 3:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
Output: [[1,2,3],[4,5,6],[7,8,9]]


 
Constraints:


	m == grid.length
	n == grid[i].length
	1 <= m <= 50
	1 <= n <= 50
	-1000 <= grid[i][j] <= 1000
	0 <= k <= 100

## Solution

**Language:** Java  
**Runtime:** 4 ms (beats 98.20%)  
**Memory:** 47 MB (beats 78.17%)  
**Submitted:** 2026-08-24T18:42:48.426Z  

```java
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        List<List<Integer>> result = new ArrayList<>();

        // Flatten grid into 1D array
        int[] flat = new int[total];
        int idx = 0;
        for (int[] row : grid) {
            for (int val : row) {
                flat[idx++] = val;
            }
        }

        // Shift using modular arithmetic
        int[] shifted = new int[total];
        for (int i = 0; i < total; i++) {
            shifted[(i + k) % total] = flat[i];
        }

        // Build result back into 2D grid
        idx = 0;
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(shifted[idx++]);
            }
            result.add(row);
        }

        return result;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/shift-2d-grid/)