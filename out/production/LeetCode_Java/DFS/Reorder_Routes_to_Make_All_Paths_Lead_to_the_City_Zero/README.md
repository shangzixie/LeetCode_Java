

# 1466. Reorder Routes to Make All Paths Lead to the City Zero

[LeetCode 1466](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/)


## Methods

### Method 1
Based on the problem description, we have a tree, and node zero is the root.

However, the direction can point either from a parent to a child (positive), or from a child to its parent (negative). 

To solve the problem, traver the tree, count the path which need to be changed:
 
1. Using the adjacency list to record edges, If the index is positive - the direction is from a parent to a child and we need to change it.

name the list as `path`. `path.get(i)` means the `i` node has a path with `path.get(i)`;

2. `visited` to avoid revisit 

3. using `change` to count the edges which need to be reverse direction. every time, when `direction > 0`, need to `+1`

### Key Points
`dfs` method

### Code
```java
public class Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            al.add(new ArrayList<>());
        for (int[] c : connections) {
            al.get(c[0]).add(c[1]);
            al.get(c[1]).add(-c[0]);
        }
        return dfs(al, new boolean[n], 0);
    }

    private int dfs(List<List<Integer>> al, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for (int to : al.get(from))
            if (!visited[Math.abs(to)])
                change += dfs(al, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
        return change;

    }
}

```

## Reference
https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/discuss/661672/C%2B%2BJava-Track-Direction