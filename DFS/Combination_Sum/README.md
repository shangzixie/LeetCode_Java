# 39. Combination Sum

[LeetCode 39](https://leetcode.com/problems/combination-sum/)


## Methods

### Method 1
use `visited` and `if (i > 0 && nums[i] == nums[i-1] && visited[i-1] == false) continue;`  to remove duplicates

### Key Points


### Code
```java
public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    List<List<Integer>> results = new LinkedList<>(); 
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> path = new LinkedList<>(); 
        boolean[] visited = new boolean[candidates.length];
        
        dfs(candidates, target, path, 0, visited); 
        return results;
    }
    
    
    private void dfs(int[] nums, int target, LinkedList<Integer> path, int startIndex, boolean[] visited){
        if (target == 0){
            this.results.add(new LinkedList(path));
            return; 
        }
        if (target < 0) return;  
        
        for (int i = startIndex;i < nums.length;i++){
            if (i > 0 && nums[i] == nums[i-1] && visited[i-1] == false) continue; //remove duplicates
            
            path.add(nums[i]);
            visited[i] = true;
            
            dfs(nums, target - nums[i], path, i, visited);
            
            visited[i] = false;
            path.removeLast(); 
        } 
        
        
    }
    
    
}

```


## Reference