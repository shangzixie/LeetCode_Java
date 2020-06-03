# 27. Remove Element

[LeetCode 27](https://leetcode.com/problems/remove-element/)


## Methods

### Method 1
`fast` `slow` pointers. everytime, if `nums[fast]` pointer is not `val`, swap it with `nums[slow]`


### Key Points


### Code
```java
public class Solution {
    /*
     * @param A: A list of integers
     * @param elem: An integer
     * @return: The new length after remove
     */
    public int removeElement(int[] nums, int val) {
        
        int slow = 0, fast = 0; 
        for(;fast < nums.length; fast++){
            if (nums[fast] != val){
                nums[slow] = nums[fast]; 
                slow++;
            }
        }
        return slow;
    }
}

```


## Reference