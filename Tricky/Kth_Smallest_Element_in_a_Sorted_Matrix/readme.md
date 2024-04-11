# [LeetCode 378. Kth Smallest Element in a Sorted Matrix](https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china)

## Methods

### Method 1

* `Time Complexity`: O(klogk)
* `Space Complexity`: O(1)
* `Intuition`:
* `Key Points`:
* `Algorithm`:

因为从左往右, 从上往下都是递增的, 我们从左上角开始, 每次节点向右或者下expand, 用heap来存储当前节点的右边和下边的节点, 从heap中pop出最小的节点, 直到第k个节点, 这个节点就是答案.

时间复杂度:
每次iteration时候, 当前节点expand的节点最多是两个, 所以heappush最多是2个节点: 2log(k). heappop 1个节点`log(k)`
总共进行k次iteration, 所以总共O(klogk)

### Code1

* `Code Design`:

```python
class Solution(object):
    def kthSmallest(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        count = 0
        heap = []
        ans = 0
        heapq.heappush(heap, (matrix[0][0], (0, 0)))
        dx = [0, 1]
        dy = [1, 0]
        while count < k:
            ans, point = heapq.heappop(heap)
            x = point[0]
            y = point[1]
            count += 1
            for i in range(len(dx)):
                nextX = x + dx[i]
                nextY = y + dy[i]
                if nextX >= len(matrix) or nextY >= len(matrix[0]):
                    continue
                if matrix[nextX][nextY] == float('-inf'):
                    continue
                heapq.heappush(heap, (matrix[nextX][nextY], (nextX, nextY)))
                matrix[nextX][nextY] = float('-inf') # mark as visited
        return ans
```

## Reference1

----------------------

### Method 2

* `Time Complexity`: 
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

最小的值为左上角, 最大的值为右下角, 是否可以以此为基础进行二分查找呢? 所以先写下二分查找的模板. 这里面我们定义一个函数`equalOrSmaller()`, 用来计算比当前中间值`mid`小于等于的数有多少个, 如果它小于`k`, 说明第`k`小的数在`mid`右边, 我们可以放弃左半部分. 如果它大于等于`k`, 说明第`k`小的数在`mid`左边, 我们可以放弃右半部分.

这里的关键是如何实现`equalOrSmaller()`?

因为矩阵每行每列都递增, 那么不大于`mid`的数, 肯定分布在矩阵的左上角. 例如下图, `mid = 8`:

![164](/Image/164.png)

所以不妨设起始点指针在左下角: `p = matrix[n - 1][0]`, 当`matrix[n - 1][0]`小于等于`mid`, 说明这一列`matrix[n - 1][0]`的上边都小于`mid`, 所以要记录进去`count`, 然后让指针`p`再往右走. 如果`matrix[n - 1][0]`大于`mid`, 我们得缩小`p`的范围, 让`p`往上走.这样每次iterate可以统计一列的数量. 最后就能统计出来所有小于等于`mid`的数的数量. 什么时候停止统计呢? 因为我们是往右上走的, 当到达右边界或上边界时候就停止了.

### Code2

* `Code Design`:

```python
class Solution(object):
    def kthSmallest(self, matrix, k):
        n = len(matrix)
        left = matrix[0][0]
        right = matrix[n - 1][n - 1]
        while left < right:
            mid = (left + right) // 2
            count = self.equalOrSmaller(mid, matrix)
            if  count < k:
                left = mid + 1 # 这里不+1会死循环, 很烦. 如果count < k, 说明 kth element一定在mid右边, 所以left = mid + 1
            else:
                right = mid
        print(left, right)
        return left

    def equalOrSmaller(self, mid, matrix):
        n = len(matrix)
        count = 0
        i = n - 1
        j = 0
        while i >= 0 and j < n:
            if matrix[i][j] <= mid:
                count += (i + 1)
                j += 1
            else:
                i -= 1
        return count

```

## Reference2


