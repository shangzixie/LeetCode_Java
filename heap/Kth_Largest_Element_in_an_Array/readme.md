# [LeetCode 215. Kth Largest Element in an Array](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)

## Methods

### Method 1

* `Time Complexity`: O(n + klogN)
* `Space Complexity`:
* `Intuition`:
* `Key Points`: max heap
* `Algorithm`:

step1: heapify, build a max heap -> O(n)
step2: keep poping out k elements -> O(klogn)

### Code1

* `Code Design`:

```python
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # heapify
        heap = [-num for num in nums]
        heapq.heapify(heap)

        ans = nums[0]
        for i in range(k):
            ans = -heapq.heappop(heap)

        return ans
```

## Reference1

----------------------

### Method 2

* `Time Complexity`: O(k) + O((n-k)logk)
* `Space Complexity`:
* `Intuition`:
* `Key Points`: min heap
* `Algorithm`:

step1: for loop array and maintain a min heap which capacity is k
step2: if current capacity is larger than k, and current element is bigger than peek, pop the peek element and push the current element
step3: in the end, the peek element is the ans

### Code2

* `Code Design`:

```python
import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for i in range(len(nums)):
            if i < k:
                heapq.heappush(heap, nums[i])
            else:
                if nums[i] > heap[0]:
                    heapq.heappop(heap)
                    heapq.heappush(heap, nums[i])

        return heap[0]
```

## Reference2

----------------------

compare method 1 and method 2:

`O(c * n + klogN)` vs `O(k) + O((n-k)logk)`

case 1: 当k很小, 远远小于n的时候:

`O(c * n)` vs `O(n * logk)`

取决于`logk` 的大小, 不好说

case 2: 最糟糕时候

k接近于n: `O(c * n + klogN)` = `O(nlogn)`
k为0.5n:  `O(k) + O((n-k)logk)` = `O(nlogn)`

所以也不好说