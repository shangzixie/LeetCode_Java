# 45. Jump Game II

[LeetCode 45](https://leetcode.com/problems/jump-game-ii/)

## Methods

### Method 1

The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd], curFarthest is the farthest point that all points in [curBegin, curEnd] can reach. Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest, then keep the above steps

### Key Points

the end index doesn't need to consider , so for loop is `int i = 0; i < nums.length - 1; i++`

### Code

```java
public class Solution {

    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int curFarthest = 0, nextFarthest = nums[0], step = 0;
        for (int i = 0; i < nums.length - 1; i++) {// the end index doesn't need to consider
            nextFarthest = Math.max(nums[i] + i, nextFarthest);
            if (i == curFarthest){
                step++;
                curFarthest = nextFarthest;
            }
        }

        return step;
    }
}

```

## Reference