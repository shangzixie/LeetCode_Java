# [LeetCode 134. Gas Station](https://leetcode-cn.com/problems/gas-station/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code1

* `Code Design`:

```Java
package LeetCode_Java.Greedy.Gas_Station;

public class Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int pathSum = 0;
        int index = 0;
        int allProfit = 0;

        for(int i = 0; i < gas.length; i++){
            pathSum += gas[i] - cost[i];
            allProfit += gas[i] - cost[i];

            if (pathSum < 0){
                pathSum = 0;
                index = i + 1;
            }
        }

        return allProfit >= 0 ? index : -1;
    }
}

```

## Reference1

[blog](https://www.cnblogs.com/yuzhangcmu/p/4179228.html)