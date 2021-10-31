# 560. Subarray Sum Equals K

[LeetCode 560](https://leetcode.com/problems/subarray-sum-equals-k/)

## Methods

### Method 1

* `Time Complexity`: O(n)
* `Intuition`: prefix sum + hashMap
* `Algorithm`:

From solution 1, we know the key to solve this problem is <code>SUM[i, j]</code>.
So if we know <code>SUM[0, i - 1]</code> and <code>SUM[0, j]</code>,
then we can easily get <code>SUM[i, j]</code>.
To achieve this, we just need to go through the array, calculate the current sum and save number of all seen <code>PreSum</code> to a HashMap. Time complexity O(n), Space complexity O(n).

### Key Points

sliding window is wrong, this is why: [explain](https://leetcode.com/problems/subarray-sum-equals-k/discuss/301242/General-summary-of-what-kind-of-problem-can-cannot-solved-by-Two-Pointers)

### Code

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // why need to put {0：1}? just because, we want newSum - oldSum = k, but if the
                        // newSum = k, oldSum = null. we need to consider this situation. such as nums =[1 2 3], k = 6
        for (int num : nums) {
            prefixSum += num; //该行放第一位，避免第一个element就是k
            if (map.containsKey(prefixSum - k)) ans += map.get(prefixSum - k);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return ans;
    }
}

```

## Reference