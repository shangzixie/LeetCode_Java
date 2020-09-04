# 189. Rotate Array

[LeetCode 796](https://leetcode.com/problems/rotate-array/)


## Methods
### Method 1
 `[x x x x | y y y]` 
 we could reverse the `x` part, then reverse the `y` part, in the end, reverse the whole array

### Key Points


### Code
```java
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length; 
        
        reverse(nums, 0, nums.length - k - 1); 
        reverse(nums, nums.length - k, nums.length - 1); 
        reverse(nums, 0, nums.length - 1); 
    }
    private void reverse(int[] nums, int start, int end) {
        
        while (start < end) {
            int temp = nums[start]; 
            nums[start] = nums[end]; 
            nums[end] = temp; 
            
            start++; 
            end--; 
        }
    }
}

```


## Reference