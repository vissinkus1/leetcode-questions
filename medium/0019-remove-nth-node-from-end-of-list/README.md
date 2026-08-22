# Remove Nth Node From End of List

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given the head of a linked list, remove the nth node from the end of the list and return its head.

 
Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]


Example 2:

Input: head = [1], n = 1
Output: []


Example 3:

Input: head = [1,2], n = 1
Output: [1]


 
Constraints:


	The number of nodes in the list is sz.
	1 <= sz <= 30
	0 <= Node.val <= 100
	1 <= n <= sz


 
Follow up: Could you do this in one pass?

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 43.1 MB (beats 95.37%)  
**Submitted:** 2026-08-22T10:37:18.617Z  

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int length(ListNode head)  {
         int cnt = 0;

        while(head!=null) {
            cnt++;
            head = head.next;
        }

        return cnt;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = length(head);
        int st = len - n + 1;

        if(st == 1) {
            return head.next;
        }

        ListNode prev = null;
        ListNode curr = head;

        while(st > 1) {
            prev = curr;
            curr = curr.next;
            st--;
        }

        prev.next = curr.next;
        return head;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)