# 34. Find First and Last Position of Element in Sorted Array

[LeetCode 34](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)


## Methods

### Method 1
use two binary search. The first one finds the left targe, and the second one finds the right target


### Key Points


### Code
```java
public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int left = 0, right = nums.length - 1;
        
        //the first binary search
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid;
            else left = mid;
        }
        int leftIndex = nums[left] == target? left : right;

        //the second binary search
        left = leftIndex;
        right = nums.length - 1;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) left = mid;
            else right = mid;
        }
        int rightIndex = nums[right] == target ? right : left;
        
        //ans 
        int[] ans = new int[2];
        if (nums[leftIndex] == target && nums[rightIndex] == target ) return new int[]{leftIndex, rightIndex};
        return new int[]{-1, -1};

    }
}

```


## Reference