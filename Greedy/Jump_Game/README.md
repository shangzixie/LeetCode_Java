# 55. Jump Game

[LeetCode 55](https://leetcode.com/problems/jump-game/)

## Methods

### Method 1

`[3,2,1,4,5]`
In index `i`, we could get the farthest index it could jump by formula `nums[i] + i`; 
so if `farthest` is less than `nums.length`, return `false`

### Key Points
we need notice `[3,2,1,0,5]` is `false`, so traverse the array, pointer `i` cann't reach a position bigger than `farthest`
so, need `i <= farthest`

### Code

```java
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;

        int farthest = 0;
        for (int i = 0; i <= farthest && i < nums.length; i++){
            if (farthest < nums[i] + i) farthest = nums[i] + i;
        }

        return farthest >= nums.length - 1? true : false;
    }
    //-------------after optimize code--------------
    public boolean canJump1(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++){
            if (i <= farthest) farthest = Math.max(nums[i] + i, farthest);
        }
    }
}


```

## Reference
