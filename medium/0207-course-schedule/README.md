# Course Schedule

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.


	For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.


Return true if you can finish all courses. Otherwise, return false.

 
Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.


Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


 
Constraints:


	1 <= numCourses <= 2000
	0 <= prerequisites.length <= 5000
	prerequisites[i].length == 2
	0 <= ai, bi < numCourses
	All the pairs prerequisites[i] are unique.

## Solution

**Language:** Java  
**Runtime:** 8 ms (beats 24.37%)  
**Memory:** 47.2 MB (beats 48.72%)  
**Submitted:** 2026-08-20T20:22:14.002Z  

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Indegree of every course
        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] pair : prerequisites) {

            int course = pair[0];
            int prerequisite = pair[1];

            graph.get(prerequisite).add(course);

            indegree[course]++;
        }

        // Courses having no prerequisites
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;

        // Topological sort
        while (!queue.isEmpty()) {

            int current = queue.poll();

            count++;

            // Remove current course's dependency
            for (int next : graph.get(current)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // If all courses were completed, no cycle exists
        return count == numCourses;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/course-schedule/)