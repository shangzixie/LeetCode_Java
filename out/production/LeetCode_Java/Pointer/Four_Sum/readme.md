# 18. 4Sum

[LeetCode 18](https://leetcode.com/problems/4sum/)


## Methods

### Method 1
* `Time Complexity`: 
* `Intuition`: same as `3sum`. use 4 pointers. every time fix `a` and `b` pointers 
* `Key Points`: Don't forget removing duplicates
* `Algorithm`: 


### Code
* `Code Design`: 
```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue; // remove duplicate
            for (int b = a + 1; b < nums.length; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) continue; // remove duplicate
                int c = b + 1, d = nums.length - 1;
                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum < target) c++;
                    else if (sum > target) d--;
                    else{
                        temp.add(nums[a]);
                        temp.add(nums[b]);
                        temp.add(nums[c]);
                        temp.add(nums[d]);
                        ans.add(new ArrayList<>(temp));
                        temp.clear();
                        c++;
                        d--;
                        while ((c < d) && (nums[c] == nums[c - 1])) c++; // remove duplicate
                        while ((c < d) && (nums[d] == nums[d + 1])) d--; // remove duplicate
                    }


                }
            }

        }
        return ans;
    }
}
```


## Reference