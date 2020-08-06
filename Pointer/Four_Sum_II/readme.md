# 454. 4Sum II

[LeetCode 454](https://leetcode.com/problems/4sum-ii/)


## Methods

### Method 1
* `Time Complexity`: O(N^2)
* `Intuition`: just like 2sum, use map. 
* `Key Points`: 
* `Algorithm`: 


### Code
* `Code Design`: 
```java
class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                ans += map.getOrDefault(-1 * (C[i] + D[j]), 0);
            }
        }
        return ans;
    }

}

```


## Reference