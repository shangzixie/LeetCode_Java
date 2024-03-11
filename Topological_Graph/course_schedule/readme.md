# [LeetCode 207. Course Schedule](https://leetcode.cn/problems/course-schedule/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code1

* `Code Design`:

```python
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        # calculate in-degree and next nodes
        courseToNext = {course : [] for course in range(numCourses)}
        courseToIndegree = {course : 0 for course in range(numCourses)}
        for re in prerequisites:
            if re[0] == re[1]:
                return False
            courseToNext[re[1]].append(re[0])
            courseToIndegree[re[0]] += 1
        # bfs
        queue = []
        for course in courseToIndegree:
            if courseToIndegree[course] == 0:
                queue.append(course)
        if len(queue) == 0:
            return False

        count = 0
        while len(queue) > 0:
            for _ in range(len(queue)):
                print(queue)
                course = queue.pop(0)
                count += 1
                for nextNode in courseToNext[course]:
                    courseToIndegree[nextNode] -= 1
                    if courseToIndegree[nextNode] == 0:
                        queue.append(nextNode)
        return count == numCourses
```

## Reference1
