# [LeetCode 556. Next Greater Element III](https://leetcode-cn.com/problems/next-greater-element-iii/)

## Methods

### Method 1

* `Time Complexity`: O(nlogn)
* `Space Complexity`: O(n)
* `Intuition`:
* `Key Points`:
* `Algorithm`:

`123421`, 我们就需要把3跟4交换位置, 再sort 4后面的所有数. 也就是说从右往左找到第一个递减的的数`3`, 然后将`3`后面比他大的最小数进行交换, 再sort

### Code1

* `Code Design`:

```python
class Solution:
    def nextGreaterElement(self, n: int) -> int:
        if n < 10:
            return -1
        numStr = str(n)
        nums = [int(numStr[i]) for i in range(len(numStr))]

        # 找到第一个递降的数 nums[i]
        i = len(nums) - 2
        while i >= 0:
            if nums[i] >= nums[i + 1]:
                i -= 1
                continue
            break
        if i < 0:
            return -1

        p = i + 1
        j = i + 1
        minNum = float('inf')
        # 找到比nums[i]大的最小数nums[j]
        while p < len(nums):
            if nums[p] > nums[i] and nums[p] < minNum:
                minNum = nums[p]
                j = p
            p += 1
        # 交换位置
        nums[i], nums[j] = nums[j], nums[i]
        nums[i+1:] = sorted(nums[i+1:])
        ans = ''
        for i in range(len(nums)):
            ans += str(nums[i])
        ans = int(ans)

        if ans > (2**31-1):
            return -1
        else:
            return ans

```

## Reference1

[youtube](https://www.youtube.com/watch?v=OKNpknDO86U&t=620s)

----------------------

### Method 2

* `Time Complexity`: O(n)
* `Space Complexity`: O(n)
* `Intuition`:
* `Key Points`:
* `Algorithm`:

方法一有两个优化点, 第一个是找到了从右向左递减的数nums[i]. 此时`i`后面的数字都是从右向左递增的, 我们可以从末尾直接遍历找到第一个大于nums[i]的数即为`最小的大于nums[i]的数`

第二个优化点是不用sort, `i`后面的数因为是一个从右向左递增的数列, 直接反转即可

### Code2

* `Code Design`:

```python
class Solution:
    def nextGreaterElement(self, n: int) -> int:
        if n < 10:
            return -1
        numStr = str(n)
        nums = [int(numStr[i]) for i in range(len(numStr))]

        i = len(nums) - 2
        # 找到第一个递降的数 nums[i]
        while i >= 0:
            if nums[i] >= nums[i + 1]:
                i -= 1
                continue
            break
        if i < 0:
            return -1

        j = len(nums) - 1
        while j > i and nums[j] <= nums[i]:
            j -= 1
        nums[i], nums[j] = nums[j], nums[i]
        nums[i+1:] = nums[i+1:][::-1] # 这里优化
        ans = ''
        for i in range(len(nums)):
            ans += str(nums[i])
        ans = int(ans)

        if ans > (2**31-1):
            return -1
        else:
            return ans


```

## Reference2
