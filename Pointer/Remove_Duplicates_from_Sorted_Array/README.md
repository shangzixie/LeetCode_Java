# 26. Remove Duplicates from Sorted Array

[LeetCode 26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)


## Methods

### Method 1
use `fast` and `slow` pointers. `slow` points to the end of non-duplicate array, `fast` points to next non-duplicate number with `slow`


### Key Points


### Code
```java
public class Solution {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */



    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length; 
        
        int slow = 0, fast = 1; 
        
        while (fast < nums.length){
            if (nums[slow] == nums[fast]){
                fast++; 
            }else{
                slow++;
                nums[slow] = nums[fast]; 
                fast++;
            }    
        }
        return slow+1;
        
    }
    //-------------after optimize
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length; 
        int slow = 0; 
        for (int fast = 1;fast<nums.length;fast++){
            if (nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1; 
    }
 
}

```


## Reference