# Merge Intervals

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 
Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].


Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.


 
Constraints:


	1 <= intervals.length <= 104
	intervals[i].length == 2
	0 <= starti <= endi <= 104

## Solution

**Language:** Java  
**Runtime:** 9 ms (beats 36.08%)  
**Memory:** 49.3 MB (beats 27.16%)  
**Submitted:** 2026-08-22T10:47:01.240Z  

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                // Overlap → merge
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // No overlap → add current and move on
                merged.add(current);
                current = intervals[i];
            }
        }
        merged.add(current); // add the last interval
        
        return merged.toArray(new int[merged.size()][]);
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/merge-intervals/)