# [31. Next Permutation](https://leetcode.com/problems/next-permutation/)

## Methods

### Method 1

from the tail to the head to find the first non-descending number, named it as `exchangeIndex1`.

Then find the first bigger number than `exchangeIndex1` from tail of array named `exchangeIndex2`, exchange them

Then reverse all subarray behead of `exchangeIndex1`

### Key Points

![](../../Image/next_permutaion1.png)

### Code

```java
public class Next_Permutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;

        //find  the first non-descending number
        int exchangeIndex1 = nums.length - 2;
        while(exchangeIndex1 >= 0 && nums[exchangeIndex1] >= nums[exchangeIndex1+1]){
            exchangeIndex1--;
        }

        // If such arrangement is not possible, 
        // it must rearrange it as the lowest possible order (ie, sorted in ascending order).
        if (exchangeIndex1 == -1){
            Arrays.sort(nums);
            return;
        }

        int exchangeIndex2 = nums.length -1;
        while(exchangeIndex2 > exchangeIndex1 && nums[exchangeIndex2] <= nums[exchangeIndex1]){
            exchangeIndex2--;
        }

        //swap nums[exchangeIndex1] with nums[exchangeIndex2]
        int temp = nums[exchangeIndex1];
        nums[exchangeIndex1] = nums[exchangeIndex2];
        nums[exchangeIndex2] = temp;

        // reverse the elements after the index of exchangeIndex2
        int left = exchangeIndex1 + 1, right = nums.length -1;
        while (left < right){
            int tem = nums[left];
            nums[left] = nums[right];
            nums[right] = tem;
            left++;
            right--;
        }
    }
}


```

## Reference

https://www.youtube.com/watch?v=zGQq3HGBTXg

### Method 2

从后往前, 判断当前数num是否为目前为止最大的数, 如果是的话继续找, 直到找到一个数不是目前为止最大的数为止. 从该数到末尾为止, 找到一个比该数大的最小数, 他们两个交换, 然后sort该数后面的所有数.

### Code

```python
class Solution:
    def nextPermutation(self, nums):
        """
        Do not return anything, modify nums in-place instead.
        """
        curMax = nums[-1]
        for i in range(len(nums) - 2, -1, -1):
            curNum = nums[i]
            # 判断当前数num是否为目前为止最大的数
            if curNum >= curMax:
                curMax = curNum
                continue
            # 如果当前数不是目前最大的数, 找到比当前数大的最小数, 其他数升序排列
            newArrIndex = i + 1
            index = len(nums) - 1 # 比当前数大的最小数的index
            minNumLargerThanCur = float('inf')
            for j in range(newArrIndex, len(nums)):
                if nums[j] > curNum and nums[j] < minNumLargerThanCur:
                    minNumLargerThanCur = nums[j]
                    index = j
            nums[index], nums[i] = nums[i], nums[index]
            nums[i+1:] = sorted(nums[i+1:])
            return nums
        return nums.sort()
```