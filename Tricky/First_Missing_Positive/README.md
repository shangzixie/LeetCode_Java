# [LeetCode 41. First Missing Positive](https://leetcode-cn.com/problems/first-missing-positive/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: use constant space complexity, and the total numbers is n. so we could use the input array as set
* `Key Points`:
* `Algorithm`:
brute force: use a Set to store all cell. Then from 1 ~ n to look for which
element is not in Set, n is the length of the array

How to optimize it to constant space complexity? use "index and negtive" to
replace Set.

If current element is in 1~n, the element is valid. So we let the index of the element to be negtive which indicates the element is valid
for example:
    [2, 6, 4, 1]  , n = nums.length;

    1. 2 is valid, so we let the 2nd element in nums to be negtive, which means 2 exist ->    [2, -6, 4, 1]
    2. 6 is out of 1~n, we let it be n+1, denotes it is invalid ->    [2, -5, 4, 1]
    3. 4 is valid, let the 4th element in nums to be negtive, which means 4 is valid -> [2, -5, 4, -1]
    4. 1 is valid -> let the 1st element in nums to be negtive, which means 1 is valid -> [-2, -5, 4, -1]

    then we find 3rd element is positive, so 3 doesn't exist

### Code1

* `Code Design`:

```java
public class Solution {
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; i++){
            if (nums[i] <= 0 || nums[i] > n) nums[i] = n + 1; //change all in-valid element to be n+1;
        }
        for (int i = 0; i < n; i++){
            int index = Math.abs(nums[i]);
            if (index == n + 1) continue; //current element is in-valid

            index--;
            if (nums[index] > 0) nums[index] = -1 * nums[index];// nums[i] is valid, so mark the index = nums[i] as negtive
        }

        for (int i = 0; i < n; i++){
            if (nums[i] > 0) return i + 1;
        }

        return n + 1;
    }
}
```

## Reference1

<https://leetcode.com/problems/first-missing-positive/discuss/17214/Java-simple-solution-with-documentation>
<https://www.youtube.com/watch?v=9SnkdYXNIzM>
