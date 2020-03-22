package LeetCode_Java.Dynamic_Programming;

public class Unique_Binary_Search_Trees {

    public int numTrees(int n) {
        if (n==0) return 1;

        // dp[i] means current i nodes will have how many BSTs.
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++){
            for (int j = 0; j< i; j++){ // j means the amount of nodes of left subtree
                       // right nodes    left nodes
                      //        |          |
                dp[i] += dp[i - j - 1] * dp[j];
            }
        }
        return dp[n];
    }
}
