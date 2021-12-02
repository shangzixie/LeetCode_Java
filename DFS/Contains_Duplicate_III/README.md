# [LeetCode 220. Contains Duplicate III](https://leetcode-cn.com/problems/contains-duplicate-iii/)

## Methods

### Method 1(Brute force)

* `Time Complexity`: O(n * k)
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

let i from 0 to the end of the array, j keeps the k distance from i. Every time, calculate in the k size window  , whether there is a nums[j] which satisfy `nums[j] - nums[i] <= t`

### Code1

* `Code Design`:

```python
class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        for i in range(len(nums)):
            j = i + 1
            while j < len(nums) and j - i <= k:
                if j < len(nums) and abs(nums[i] - nums[j]) <= t:
                    return True
                j += 1
        return False
```

## Reference1

----------------------

### Method 2

* `Time Complexity`: O(n* logk)
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

how to build a k size window and maintain it (by using algorithm or data structure)?
the window should have the following features:
    1. every time maintain k size
    2. every time it could give you the closest number when you input a specific number
TreeSet
it has ceiling and floor method, which will give you the smallest number larger than nums[i] and the largest number smaller than nums[i]

treeset is a black-red tree

### Code2

* `Code Design`:

```java
package LeetCode_Java.DFS.Contains_Duplicate_III;

import java.util.TreeSet;

public class Contains_Duplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i ++){
            Integer ceil = set.ceiling(nums[i]); // the smallest number larger than nums[i]
            if (ceil != null && Long.valueOf(ceil) - Long.valueOf(nums[i]) <= t) return true;

            Integer floor = set.floor(nums[i]); // the largest number smaller than nums[i]
            if (floor != null && Long.valueOf(nums[i]) - Long.valueOf(floor) <= t ) return true;

            set.add(nums[i]);
            if (i >= k) set.remove(nums[i-k]);
        }
        return false;
    }
}
```

## Reference2

----------------------

### Method 3(best method)

* `Time Complexity`: O(n)
* `Space Complexity`: O(k)
* `Intuition`: bucket
* `Key Points`:
* `Algorithm`:


### Code3

* `Code Design`:

```java

```

## Reference3

[video](https://www.youtube.com/watch?v=yc4hCFzNNQc&t=840s)