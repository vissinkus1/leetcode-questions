# Design Skiplist

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Design a Skiplist without using any built-in libraries.

A skiplist is a data structure that takes O(log(n)) time to add, erase and search. Comparing with treap and red-black tree which has the same function and performance, the code length of Skiplist can be comparatively short and the idea behind Skiplists is just simple linked lists.

For example, we have a Skiplist containing [30,40,50,60,70,90] and we want to add 80 and 45 into it. The Skiplist works this way:


Artyom Kalinin [CC BY-SA 3.0], via Wikimedia Commons

You can see there are many layers in the Skiplist. Each layer is a sorted linked list. With the help of the top layers, add, erase and search can be faster than O(n). It can be proven that the average time complexity for each operation is O(log(n)) and space complexity is O(n).

See more about Skiplist: https://en.wikipedia.org/wiki/Skip_list

Implement the Skiplist class:


	Skiplist() Initializes the object of the skiplist.
	bool search(int target) Returns true if the integer target exists in the Skiplist or false otherwise.
	void add(int num) Inserts the value num into the SkipList.
	bool erase(int num) Removes the value num from the Skiplist and returns true. If num does not exist in the Skiplist, do nothing and return false. If there exist multiple num values, removing any one of them is fine.


Note that duplicates may exist in the Skiplist, your code needs to handle this situation.

 
Example 1:

Input
["Skiplist", "add", "add", "add", "search", "add", "search", "erase", "erase", "search"]
[[], [1], [2], [3], [0], [4], [1], [0], [1], [1]]
Output
[null, null, null, null, false, null, true, false, true, false]

Explanation
Skiplist skiplist = new Skiplist();
skiplist.add(1);
skiplist.add(2);
skiplist.add(3);
skiplist.search(0); // return False
skiplist.add(4);
skiplist.search(1); // return True
skiplist.erase(0);  // return False, 0 is not in skiplist.
skiplist.erase(1);  // return True
skiplist.search(1); // return False, 1 has already been erased.

 
Constraints:


	0 <= num, target <= 2 * 104
	At most 5 * 104 calls will be made to search, add, and erase.

## Solution

**Language:** Java  
**Runtime:** 25 ms (beats 62.91%)  
**Memory:** 65.8 MB (beats 58.13%)  
**Submitted:** 2026-08-22T10:36:31.704Z  

```java
import java.util.*;

class Skiplist {
    static class Node {
        int val;
        Node[] forward;
        Node(int val, int level) {
            this.val = val;
            this.forward = new Node[level + 1];
        }
    }

    private static final int MAX_LEVEL = 16;
    private static final double P = 0.5;
    private Node head;
    private int level;
    private Random rand;

    public Skiplist() {
        head = new Node(-1, MAX_LEVEL);
        level = 0;
        rand = new Random();
    }

    private int randomLevel() {
        int lvl = 0;
        while (rand.nextDouble() < P && lvl < MAX_LEVEL) {
            lvl++;
        }
        return lvl;
    }

    public boolean search(int target) {
        Node curr = head;
        for (int i = level; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < target) {
                curr = curr.forward[i];
            }
        }
        curr = curr.forward[0];
        return curr != null && curr.val == target;
    }

    public void add(int num) {
        Node[] update = new Node[MAX_LEVEL + 1];
        Node curr = head;
        for (int i = level; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        int lvl = randomLevel();
        if (lvl > level) {
            for (int i = level + 1; i <= lvl; i++) {
                update[i] = head;
            }
            level = lvl;
        }

        Node newNode = new Node(num, lvl);
        for (int i = 0; i <= lvl; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    public boolean erase(int num) {
        Node[] update = new Node[MAX_LEVEL + 1];
        Node curr = head;
        for (int i = level; i >= 0; i--) {
            while (curr.forward[i] != null && curr.forward[i].val < num) {
                curr = curr.forward[i];
            }
            update[i] = curr;
        }

        curr = curr.forward[0];
        if (curr == null || curr.val != num) return false;

        for (int i = 0; i <= level; i++) {
            if (update[i].forward[i] != curr) break;
            update[i].forward[i] = curr.forward[i];
        }

        while (level > 0 && head.forward[level] == null) {
            level--;
        }
        return true;
    }
}

```

---

[View on LeetCode](https://leetcode.com/problems/design-skiplist/)