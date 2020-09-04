# 52. N-Queens II

[LeetCode 52](https://leetcode.com/problems/n-queens-ii/)


## Methods

### Method 1
It is better to do [N-Queens_I](../N_Queens) first
* `Time Complexity`: N !
* `Intuition`: DFS
* `Algorithm`: 
    1. DFS, `row` begin from `0` to try all possibility
    2. use 3 `sets` to examine valid 


### Key Points


### Code
```java
class Solution {
    Set<Integer> colVisited; 
    Set<Integer> d1; 
    Set<Integer> d2; 
    int ans; 
    public int totalNQueens(int n) {
        colVisited = new HashSet<>(); 
        d1 = new HashSet<>(); 
        d2 = new HashSet<>(); 
        ans = 0; 
        
        dfs(0, n); 
        return ans; 
    }
    private void dfs(int row, int n) {
        if (row == n) {
            ans++; 
            return; 
        }
        
        for (int col = 0; col < n; col++) {
            if (colVisited.contains(col) || d1.contains(col + row) || d2.contains(row - col)) continue; 
            
            colVisited.add(col); 
            d1.add(col + row); 
            d2.add(row - col); 
            
            dfs(row + 1, n); 
            
            colVisited.remove(col);
            d1.remove(col + row); 
            d2.remove(row - col);
        }
    }
}

```


## Reference