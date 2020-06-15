# 1482. Minimum Number of Days to Make m Bouquets

[LeetCode 1482](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/)


## Methods
brute force is to simulate the days. `day = 0`, every time, `day + 1` then check the continuous days. 
but the time complexity is high. so, we could use `binary search` 

### Method 1
```
Time O(Nlog(maxA))
Space O(1) 
 ```

`left = 1` is the smallest days,
`right = 1e9` is surely big enough to get m bouquests.
So we are going to binary search in range `[left, right]`

Given `mid` days, we can know which flowers blooms.
Now the problem is, given an array of `true` and `false`,
find out how many adjacent `true` bouquest in total.

If `bouq < m`, mid is still small for `m`bouquest.
So we turn `left = mid + 1`

If `bouq >= m`, mid is big enough for `m` bouquest.
So we turn `right = mid`




### Code
```java
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1; 
        
        int left = 0, right = (int)1e9; 
        
        while (left + 1 < right){
            int mid = left + (right - left) / 2; 
            int bouq = 0, continuous = 0; 
            
            for (int i = 0; i < bloomDay.length; i++){
                if (bloomDay[i] > mid){
                    continuous = 0;
                }else if (++continuous >= k){
                    bouq++; 
                    continuous = 0;
                } 
            }
            if (bouq < m) left = mid; // means the bouq is not enough, increase the days
            else right = mid; 
        }

        return right;
        
    }
}
```
### Key Points
```java

if (bloomDay[i] > mid){
    continuous = 0;
}else if (++continuous >= k){
    bouq++; 
    continuous = 0;
} 
```

is the same to 

```java
if (bloomDay[i] > mid){
    continuous = 0;
}else{
    continuous++;
    if (continuous >= k){
        bouq++; 
        continuous = 0;
    } 
} 


```



## Reference
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/discuss/686316/JavaC%2B%2BPython-Binary-Search