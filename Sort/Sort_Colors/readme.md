# [LeetCode 75. Sort Colors](https://leetcode-cn.com/problems/sort-colors/)

## Methods

一般方法, quick sort 或者 merge sort 一定能解决,  时间复杂度 `O(nlogN)`, 有没有可能优化?

1. 当然可以考虑计数排序, 扫描一遍记录每个数字出现的次数. 然后再重新建立一个排好序的数组就行, 时间复杂度O(n)
2. 是否可以利用quick sort的思想呢?

### Method 1

* `Time Complexity`: O(n)
* `Space Complexity`: O(1)
* `Intuition`: iterate array two times + just one pointer
* `Key Points`:
* `Algorithm`:

![98](../../Image/98.png)
(图片有误, 应该理解为方法一: 两指针)

### Code1

* `Code Design`:

```java
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }
}

```

## Reference1

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code2

* `Code Design`:

```java


```

## Reference2
