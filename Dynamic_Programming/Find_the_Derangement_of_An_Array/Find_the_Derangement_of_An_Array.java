package LeetCode_Java.Dynamic_Programming.Find_the_Derangement_of_An_Array;

/*
f[i] means if there are i numbers, how many derangement arrays it will produce.

function: f[i] = (i - 1) * (f[i-1] + f[i-2])
f[0] = 0 , f[1] = 1;


我们来想n = 4时该怎么求，我们假设把4排在了第k位，这里我们就让k = 3吧，那么我们就把4放到了3的位置，变成了：
x x 4 x
我们看被4占了位置的3，应该放到哪里，这里分两种情况，如果3放到了4的位置，那么有：
x x 4 3
那么此时4和3的位置都确定了，实际上只用排1和2了，那么就相当于只排1和2，就是dp[2]的值，是已知的。
那么再来看第二种情况，3不在4的位置，那么此时我们把4去掉的话，就又变成了：
x x x
这里3不能放在第3个x的位置，在去掉4之前，这里是移动4之前的4的位置，那么实际上这又变成了排1，2，3的情况了，就是dp[3]的值。

再回到最开始我们选k的时候，我们当时选了k = 3，其实k可以等于1,2,3，也就是有三种情况，所以dp[4] = 3 * (dp[3] + dp[2])。
那么递推公式也就出来了：
dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2])


归纳：
如果有n个数。第n个数如果放在第k个位置，那么第k个数就有两种放法，1.放到第n个位置 2. 放到其他位置
1.如果第k个数放到第n个位置（也就是n和k交换）：
x x x x ...x x k x x ... n --> x x x x ...x x n x x ... k
那么去掉 x和 n， 就是一个求n-2个数的Derangement


2. 如果第k个数不放到第n个位置：
x x x x ...x x k x x ... n --> x x x x ...x x n x x ... + k
这个时候我们把n的位置去掉
--> x x x x ...x x x x ... + k  这时候k不能放在最后一个位置。那是不是这道题可以转化为了 --> x x x x ...x x x x ... k 总共n-1个数的derangement问题？

所以第n个数放在第k个位置，这个k总共有n-1个  所以为 f[n] = (n-1) * (f[n-1] + f[n-2])
 */

public class Find_the_Derangement_of_An_Array {
    public int findDerangement(int n) {
        if (n ==1) return 0;

        long[] dp = new long[n+1];
        long mod = (long)Math.pow(10, 9) + 7;

        dp[2] = 1;
        for (int i =3; i < n+1; i ++){
            dp[i] = (i -1) * (dp[i-1] + dp[i-2]) % mod;

        }
        return (int)dp[n];
    }
}
