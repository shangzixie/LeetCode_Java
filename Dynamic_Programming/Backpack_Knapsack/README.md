
```
f[i][j]=max{f[i-1][j],f[i-1][j-w[i]]+v[i]}
w[] is weight 
v[] is value 
```

## 1. [0/1 problem](Backpack_I)
the video is excellent [video 1](https://www.youtube.com/watch?v=nLmhmB6NzcM&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O&index=54)
, [video 2](https://www.youtube.com/watch?v=zRza99HPvkQ&list=PLDN4rrl48XKpZkf03iYFl-O29szjTrs_O&index=55)

then we will get the code 
```java
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
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
