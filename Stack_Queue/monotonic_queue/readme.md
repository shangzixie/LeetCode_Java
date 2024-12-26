# monotonic queue

基础知识, 如何用双端queue维护一个滑动窗口的最大值或者最小值

## 滑动窗口内最小值

![174](/Image/174.png)

input为一个数组`arr`, 和一个滑动窗口的长度`k`, 输出每个窗口的最小值. notice that `len(arr)` >= k

```python
from collections import deque

def min_sliding_window(nums, k):
    # 单调队列，存储元素的索引
    mono_queue = deque()
    result = []

    for i in range(len(nums)):
        # 移除不在滑动窗口范围内的元素
        if mono_queue and mono_queue[0] < i - k + 1:
            mono_queue.popleft()

        # 维护单调递增
        while mono_queue and nums[mono_queue[-1]] > nums[i]:
            mono_queue.pop()

        # 加入当前元素索引
        mono_queue.append(i)

        # 当前滑动窗口已经形成，记录最小值
        if i >= k - 1:
            result.append(nums[mono_queue[0]])

    return result

```

## 滑动窗口内最大值

![175](/Image/175.png)

```python

from collections import deque

def max_sliding_window(nums, k):
    # 单调队列，存储元素的索引
    mono_queue = deque()
    result = []
    
    for i in range(len(nums)):
        # 移除不在滑动窗口范围内的元素
        if mono_queue and mono_queue[0] < i - k + 1:
            mono_queue.popleft()
        
        # 维护单调递减
        while mono_queue and nums[mono_queue[-1]] < nums[i]:
            mono_queue.pop()
        
        # 加入当前元素索引
        mono_queue.append(i)
        
        # 当前滑动窗口已经形成，记录最大值
        if i >= k - 1:
            result.append(nums[mono_queue[0]])
    
    return result

```
