package LeetCode_Java.Dynamic_Programming.Palindrome_Partitioning_II;

public class Palindrome_Partitioning_II {
    public int minCut(String s) {
        // write your code here
        if (s.length() < 2) return 0;

        boolean[][] isPa = isPalindrome(s);

        int[] dp = new int[s.length()]; // dp means 0-i in string needs the number of curts

        for (int i = 0; i < s.length(); i++){
            if (isPa[0][i]){
                dp[i] = 0;
                continue;
            }
            dp[i] = i;
            for (int j =0; j < i; j++){
                if (isPa[j+1][i]){
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }

        }
        return dp[s.length()-1];
    }


    private boolean[][] isPalindrome(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];


        for (int i = 0; i < n ; i++ ) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n-1; i++){
            if (s.charAt(i) == s.charAt(i+1)) dp[i][i+1] = true;
        }


        for (int len = 3; len < n + 1; len++){
            for (int i = 0; i < n - len + 1; i++){
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)  ) dp[i][j] = dp[i+1][j-1];
            }
        }
        return dp;
    }

}
