# 1552. Magnetic Force Between Two Balls

[LeetCode 1552](https://leetcode.com/problems/magnetic-force-between-two-balls/)


## Methods

### Method 1
* `Time Complexity`: 
* `Intuition`:
* `Key Points`: 
* `Algorithm`: 
This question is: give some baskets, put balls into them so as `min interval` between two balls has 
max value.

If we define the distance of two balls is `d`, we could get the max number of balls we could put. By using 
a funtion `count(d)` 

We want to find the biggest `d`, so we could try all possible `d` by using `count(d)`, if 
1. `count(d) > m`, it means when put all balls into baskets, their distance is `d`, and we can put up to `count(d)` balls. But 
it bigger than m, so the distance is not `max`, we need to increase `d`

2. `count(d) < m`, it means when put all balls into baskets, their distance is `d`, and we can put up to `count(d)` balls. But 
   it smaller than m, so the distance is too big , we need to decrease `d`


### Code
* `Code Design`:
Since `count(d)` is monotonically decreasing with respect to `d`, we can use binary search to find the optimal `d` 
use `bisect_right` binary search
```java
class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position); // logN
        int left = 0, right = position[position.length - 1];

        // binary search to confirm d
        while (left + 1< right) {
            int mid = left + (right - left) / 2;
            if (count(mid, position) >= m) left = mid;
            else right = mid;
        }
        return count(right, position) == m? right : left;
    }

    private int count(int d, int[] position) {
        int cur = position[0], ballsCouldPut = 1;

        for (int i = 0; i < position.length; i++) {
            if (position[i] - cur >= d) {
                ballsCouldPut++;
                cur = position[i];
            }
        }
        return ballsCouldPut;
    }
}

```


## Reference