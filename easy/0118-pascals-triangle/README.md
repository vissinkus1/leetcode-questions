# Pascal's Triangle

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

 
Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:
Input: numRows = 1
Output: [[1]]

 
Constraints:


	1 <= numRows <= 30

## Solution

**Language:** Java  
**Runtime:** 1 ms (beats 95.44%)  
**Memory:** 43.6 MB (beats 34.75%)  
**Submitted:** 2026-08-23T12:35:00.675Z  

```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();

    //numrow=5
     result.add(new ArrayList<Integer>());
     result.get(0).add(1);
     //1
     //
      for(int row=1;row<numRows;row++){
        List<Integer> newRow=new ArrayList<>();
        newRow.add(1);
        List<Integer>prevRow = result.get(row-1);
        for(int i=1;i<row;i++){
            newRow.add(prevRow.get(i)+prevRow.get(i-1));
        }
        newRow.add(1);
        result.add(newRow);
         
      }
      return result;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/pascals-triangle/)