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
**Runtime:** 0 ms  
**Memory:** 42.6 MB  
**Submitted:** 2026-08-23T12:34:53.541Z  

```java
        newRow.add(1);
        for(int i=1;i<row;i++){
        List<Integer>prevRow = result.get(row-1);
            newRow.add(prevRow.get(i)+prevRow.get(i-1));
        List<Integer> newRow=new ArrayList<>();
      for(int row=1;row<numRows;row++){
     //
     //1
     result.get(0).add(1);
     result.add(new ArrayList<Integer>());
    //numrow=5

        List<List<Integer>> result=new ArrayList<List<Integer>>();
    public List<List<Integer>> generate(int numRows) {
class Solution {

```

---

[View on LeetCode](https://leetcode.com/problems/pascals-triangle/)