# [LeetCode 153. Find Minimum in Rotated Sorted Array](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

 separate the nums to 2 parts;
  小————大 小小小————小小

对于`[0,1,2,3,4,5,6,7]`一开始时候只有三种情况:

```python
case1: [2,4,5,6,7,0,1], 左半部分[2,4,5,6]是sorted, 右半部分[6,7,0,1]不是sorted
case2: [5,6,7,0,1,2,4], 左半部分[5,6,7,0]不是sorted, 右半部分[0,1,2,4]是sorted
case3: [0,1,2,4,5,6,7], 左半部分[5,6,7,0]是sorted, 右半部分[0,1,2,4]是sorted
```

左边是sorted时候, 最小值在右边
右边是sorted. 最小值在左边边
都是sorted, 最小是没变位置

### Code1

* `Code Design`:

```java

public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        // means it doesn't rotated
        if (nums[0] < nums[nums.length-1]) return nums[0];

        // if it rotated
        int start = 0, end = nums.length-1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            //if mid is minimum
            // 45671234
            //     |
            if (mid > 0 && nums[mid] < nums[mid-1]) return nums[mid];

            // binary search

            // min is at right part
            if (nums[mid] > nums[start])  start = mid;
            else end = mid;
        }

        return nums[start] < nums[end]? nums[start] : nums[end];
    }
}
```

## Reference1

[video](https://www.youtube.com/watch?v=MzoL02wd5ag)
