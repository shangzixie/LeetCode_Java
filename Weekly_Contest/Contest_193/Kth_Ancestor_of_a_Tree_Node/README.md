# 1483. Kth Ancestor of a Tree Node

[LeetCode 1483](https://leetcode.com/problems/kth-ancestor-of-a-tree-node/)


## Methods
### Method 1
```
time: O(n * Logn)
```

1. use `binary lifting` preprocessing the data. it will take `n * logn` time complexity.

2. use [Fast Power](../../../Math/Pow) method to look for the Kth ancestor. take `logn` time complexity 
### Key Points


### Code
```java
public class TreeAncestor {
    int[][] dp;
    int maxLevel;

    public TreeAncestor(int n, int[] parent) {
        maxLevel = (int)(Math.log(n) / Math.log(2)) + 1; // maxLevel = int (log2(n) + 1)
        dp = new int[maxLevel][n]; // dp[i][node] means the 2^i ancestor of the node (it is flipped matrix different from a normal dp)
        dp[0] = parent; //initial condition: all node's parent
        for (int level = 1; level < maxLevel; level++) {
            for (int node = 0; node < n; node++) {
                int pre = dp[level - 1][node];
                dp[level][node] = pre == -1 ? -1 : dp[level - 1][pre];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int power = this.maxLevel;
        while (k > 0 && node > -1) {

            if (k < 1 << power) { // (1 << power) = (2^power)
                power--; // let power from highest to decrease
            }else {
                node = dp[power][node]; // find the maxLevel ancestor of node
                k -= 1 << power;
            }
        }
        return node;
    }
}

```


## Reference
[Chinese Explains](https://leetcode-cn.com/problems/kth-ancestor-of-a-tree-node/solution/li-kou-zai-zhu-jian-ba-acm-mo-ban-ti-ban-shang-lai/)