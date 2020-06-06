time complexity: O(n) 

if an array has number from 1 - n, such as [4 3 2 1], we want to get [1 2 3 4]
every number `nums[i]` should move to the array's index =  `nums[i] -1`

so we can swap it, the formula is `nums[i] swap to nums[index] && index = nums[i] -1` as well as 
`nums[i] swap to nums[nums[i] -1]`