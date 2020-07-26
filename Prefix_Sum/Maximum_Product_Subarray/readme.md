# **. **

[LeetCode ]()


## Methods

### Method 1 - code is bad 
* `Time Complexity`: O(n)
* `Intuition`: prefix Product
* `Key Points`: There are positive, negtive, zero number. So we need consider the 3 situations.
* `Algorithm`: 
if prefix Product is positive: 

`max product = positve prefix Product / min positive prefix Product`

or

if prefix product is negtive: 
 
`max product = negtive prefix Product / max negtive prefix Product`

if current is zero: 

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


## Reference