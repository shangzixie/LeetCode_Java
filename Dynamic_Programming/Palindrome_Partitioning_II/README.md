![](../../Image/Palindrome_Partitioning_II.png)


this question, firstly, we need to understand the question

"abc" needs 2 cuts, "abcdef" needs 5 cuts

Then we need two dp

1. the first one is to judge all substring is a palindrome or not;

2. the second one means the answer-- dp[i] = 0-i in string needs the number of cuts