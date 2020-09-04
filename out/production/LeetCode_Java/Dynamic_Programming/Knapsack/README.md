


```
f[i][v]表示前i件物品恰放入一个容量为v的背包可以获得的最大价值
f[i][v]=max{f[i-1][v],f[i-1][v-v[i]]+w[i]}
w[] is weight 
v[] is value 
```

## 1. 0/1 problem

### Description
There are `n` items and a backpack with size `m`. Given array `A` representing the size of each item and array `V` representing the value of each item.

What's the maximum value can you put into the backpack?

1. A[i], V[i], n, m are all integers.
2. You can not split an item.
3. The sum size of the items you want to put into backpack can not exceed m.
4. Each item can only be picked up once

Example1:
``` 
Input: m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4]
Output: 9
Explanation: Put A[1] and A[3] into backpack, getting the maximum value V[1] + V[3] = 9 
```

Example2:
``` 
Input: m = 10, A = [2, 3, 8], V = [2, 5, 8]
Output: 10
Explanation: Put A[0] and A[2] into backpack, getting the maximum value V[0] + V[2] = 10 
```

### Explain 

the video is excellent [video 1](https://www.youtube.com/watch?v=nLmhmB6NzcM&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O&index=54)
, [video 2](https://www.youtube.com/watch?v=zRza99HPvkQ&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O&index=55)

then we will get the code 
```java
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return : The maximum value
     */
    public int backPackII1(int m, int[] A, int[] V) {
        // 2d array 
        int[][] dp = new int[A.length + 1][m + 1]; 
        
        for (int i = 0; i <= A.length; i++){
            for (int j = 0; j <= m; j++){
                if (i == 0 || j == 0) dp[i][j] = 0;  // if i == 0, dp[i-1] will invalid
                else if (j < A[i - 1]) dp[i][j] = dp[i-1][j];  // if j < A[i-1], dp[i-1][j - A[i-1]] will invalid 
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - A[i-1]] + V[i-1]);
            }
        }
        
        return dp[A.length][m];
    }
}

```
