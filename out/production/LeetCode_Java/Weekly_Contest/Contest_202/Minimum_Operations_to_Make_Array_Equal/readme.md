# 1551. Minimum Operations to Make Array Equal

[LeetCode 1551](https://leetcode.com/problems/minimum-operations-to-make-array-equal/)


## Methods

### Method 1
* `Time Complexity`: 
* `Intuition`:
* `Key Points`: 
* `Algorithm`: 
I don't know what to say, because it is so easy...

### Code
* `Code Design`: 
```java
class Solution {
    public int minOperations(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 2 * i + 1;
        }

        int target = (arr[n-1] + 1) / 2;
        int ans = 0;
        for (int i = 0; i < n / 2; i++) ans += (target - arr[i]);
        return ans;
    }
}

```
after optimize


```java
class Solution {
    public int minOperations(int n) {
        int target = ((n - 1) * 2 + 2) / 2;
        int ans = 0;
        for (int i = 0; i < n / 2; i++) ans += (target - (i * 2 + 1));
        return ans;
    }
}

```


## Reference