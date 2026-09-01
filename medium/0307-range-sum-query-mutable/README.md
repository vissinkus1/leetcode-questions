# Range Sum Query - Mutable

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array nums, handle multiple queries of the following types:


	Update the value of an element in nums.
	Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.


Implement the NumArray class:


	NumArray(int[] nums) Initializes the object with the integer array nums.
	void update(int index, int val) Updates the value of nums[index] to be val.
	int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


 
Example 1:

Input
["NumArray", "sumRange", "update", "sumRange"]
[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
Output
[null, 9, null, 8]

Explanation
NumArray numArray = new NumArray([1, 3, 5]);
numArray.sumRange(0, 2); // return 1 + 3 + 5 = 9
numArray.update(1, 2);   // nums = [1, 2, 5]
numArray.sumRange(0, 2); // return 1 + 2 + 5 = 8


 
Constraints:


	1 <= nums.length <= 3 * 104
	-100 <= nums[i] <= 100
	0 <= index < nums.length
	-100 <= val <= 100
	0 <= left <= right < nums.length
	At most 3 * 104 calls will be made to update and sumRange.

## Solution

**Language:** Java  
**Runtime:** 79 ms (beats 68.46%)  
**Memory:** 134.7 MB (beats 22.37%)  
**Submitted:** 2026-09-01T08:28:20.017Z  

```java
class NumArray {
    private int[] tree;
    private int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[2 * n];
        buildTree(nums);
    }

    private void buildTree(int[] nums) {
        // Fill leaves
        for (int i = 0; i < n; i++) {
            tree[n + i] = nums[i];
        }
        // Build parents
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    public void update(int index, int val) {
        int pos = index + n;
        tree[pos] = val;
        while (pos > 1) {
            pos /= 2;
            tree[pos] = tree[2 * pos] + tree[2 * pos + 1];
        }
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        left += n;
        right += n;
        while (left <= right) {
            if ((left & 1) == 1) sum += tree[left++];
            if ((right & 1) == 0) sum += tree[right--];
            left /= 2;
            right /= 2;
        }
        return sum;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/range-sum-query-mutable/)