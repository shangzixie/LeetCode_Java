For a dynamic problem, the basic process is: `make sure the status -> define meaning of the dp array -> make sure the choice -> make sure the base case`

1. [Backpack_I](Backpack_I)

**Status and dp**:

the status is the `size` of the `i` item. so `dp[i]` means the total size until the `i` item;

**Choice**:

the  choice for `dp[i]` is that it is selected or not, so`max(choose current item, don't choose it)`, that is to say `max(dp[i-1] + A[i], dp[i-1])`. 
So we get `dp[i] = max(dp[i-1] + A[i], dp[i-1])`

**Base Case**:

for the first item, it could be selected or not. so `dp[0] = `