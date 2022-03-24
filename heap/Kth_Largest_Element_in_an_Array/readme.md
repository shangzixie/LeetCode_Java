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

----------------------

### Method 3

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`: quick partition
* `Algorithm`:

### Code3

* `Code Design`:

```java
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的下标是 len - k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    /**
     * 对数组 nums 的子区间 [left..right] 执行 partition 操作，返回 nums[left] 排序以后应该在的位置
     * 在遍历过程中保持循环不变量的定义：
     * nums[left + 1..j] < nums[left]
     * nums(j..i) >= nums[left]
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // j 的初值为 left，先右移，再交换，小于 pivot 的元素都被交换到前面
                j++;
                swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中，满足 nums[left + 1..j] < pivot，并且 nums(j..i) >= pivot
        swap(nums, j, left);
        // 交换以后 nums[left..j - 1] < pivot, nums[j] = pivot, nums[j + 1..right] >= pivot
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
```
