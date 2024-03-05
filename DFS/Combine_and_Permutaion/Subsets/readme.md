# [LeetCode 78. Subsets](https://leetcode.cn/problems/subsets/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

![129](/Image/129.png)

for every number, there are two choices: add it to the subset or not. So we can use dfs to solve this problem.

### Code1

* `Code Design`:

```java
class Solution {
    public List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<Integer>());
        return ans;
    }

    public void dfs(int[] nums, int startIndex, ArrayList<Integer> subArray) {
        if (startIndex == nums.length) {
            ans.add(new ArrayList<Integer>(subArray)); // attention!! need to build a new array
            return;
        }
        subArray.add(nums[startIndex]);
        dfs(nums, startIndex + 1, subArray);
        subArray.remove(subArray.size() - 1);
        dfs(nums, startIndex + 1, subArray);
    }
}

```

## Reference1
