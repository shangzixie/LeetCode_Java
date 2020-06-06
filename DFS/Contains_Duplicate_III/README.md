```
nums: x x x i x x .. x j x x ..

1. | nums[j] - nums[i] | <= t
2. | j - i | <= k
```

there are two dimension, we firstly need to consider to maintain one dimension and to compare the other dimension.
we find `| i - j | <= k` is easy to maintain. 

1. Brute force:

let i from 0 to the end of the array, j keeps the k distance from i. Every time, calculate in the k size window  
, whether there is a nums[j] which satisfy `nums[j] - nums[i] <= t` 

time complexity: O(n * k)


2. how to build a k size window and maintain it (by using algorithm or data structure)?
the window should have the following features:
    
    1. every time maintain k size
    2. every time it could give you the closest number when you input a specific number 


TreeSet ! 
it has ceiling and floor method, which will give you the smallest number larger than nums[i] and 
the largest number smaller than nums[i]   

time complexity O(n* logk)