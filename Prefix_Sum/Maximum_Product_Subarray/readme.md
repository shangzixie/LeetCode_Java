# 152. maximum product subarray

[LeetCode 152](https://leetcode.com/problems/maximum-product-subarray/)


## Methods

### Method 1 - the method is not the best method for all input is integer, but is appropriate for non-integer  
* `Time Complexity`: O(n)
* `Intuition`: prefix Product
* `Key Points`: There are positive, negtive, zero number. So we need consider the 3 situations.
* `Algorithm`: 

1. if prefix Product is positive: 

`max product = positve prefix Product / min positive prefix Product`

2. if prefix product is negtive: 
 
`max product = negtive prefix Product / max negtive prefix Product`

3. if current is zero: 

all variable Will be initialized. 


### Code
```java
public class Solution {

    public int maxProduct(int[] nums) {
        int prefixProduct = 1;
        int minPositive = 1, maxNegtive = 1;
        int ans = Integer.MIN_VALUE;

        for (int num : nums) {
            prefixProduct *= num;

            if (prefixProduct > 0) {
                ans = Math.max(ans, prefixProduct / minPositive);
                minPositive = Math.min(minPositive, prefixProduct);
            } else if (prefixProduct < 0) {
                ans = Math.max(ans, prefixProduct / maxNegtive);
                maxNegtive = maxNegtive == 1 ? prefixProduct : Math.max(maxNegtive, prefixProduct);
            } else {
                ans = Math.max(ans, 0);
                prefixProduct = 1;
                minPositive = 1; 
                maxNegtive = 1; 
            }

        }
        return ans;
    }
}

```

### Method 2 - best method for all input is integer
* `Time Complexity`: O(n)
* `Intuition`: prefix Product
* `Key Points`: There are positive, negtive, zero number. So we need consider the 3 situations.
* `Algorithm`: 

First, Consider there is no zero, and if we get the products of all the numbers:
1) We will have a negative result if there are odd numbers of negative -> `max ((product of (0, last negative index- 1)), (product of (first negative index + 1, last num))`
2) We will have a positive result if there are even numbers of negative -> product of all the numbers
Above all, we can get the max by going through the array from both start and end, then we won't miss any situations
If there is a zero, that means we would have two subproblems(unless the zero is at index 0 or last index), if two zeros, 3 subs, all the way up. We still can calculate from the very beginning and end at the same time, then we would get the result.

### Code
* `Code Design`:
we could from left to right th traverse the whole array, and from right to left to traverse the whole array. 
we could cover all situations above. 

```java 
class Solution{
    public int maxProduct(int[] nums) {
        
        int prefix = 1, ans = Integer.MIN_VALUE;
        
        // from left to right
        for (int i = 0; i < nums.length;i++) {
            if (nums[i] == 0) {
                prefix = 1; 
                ans = Math.max(0, ans); // for case [-2, 0, -1]
                continue; 
            }    
            prefix *= nums[i];
            ans = Math.max(ans, prefix);
        }
        
        // from right to left 
        prefix = 1; 
        for (int i = nums.length - 1; i >= 0;i--) {
            if (nums[i] == 0) {
                prefix = 1; 
                ans = Math.max(0, ans);// for case [-2, 0, -1]
                continue; 
            }    
            prefix *= nums[i]; 
            ans = Math.max(ans, prefix);
        }
        return ans;
    }
}


```


## Reference
[LeetCode Explain](https://leetcode.com/problems/maximum-product-subarray/discuss/183483/In-Python-it-can-be-more-concise-PythonC%2B%2BJava)