package LeetCode_Java.Dynamic_Programming.Regular_Expression_Matching;

public class Regular_Expression_Matching {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        s = "#" + s;
        p = "#" + p;

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for (int j = 2; j < n + 1; j++){
            dp[0][j] = (p.charAt(j) == '*') && dp[0][j-2];
        }


        for (int i = 1;i < m + 1 ; i++){
            for (int j = 1; j < n + 1; j++) {
                if (Character.isLetter(p.charAt(j))){
                    dp[i][j] = ((s.charAt(i) == p.charAt(j))) && dp[i-1][j-1];
                }else if (p.charAt(j) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }else if (p.charAt(j) == '*'){
                    boolean possible1 = dp[i][j-2];  // （字母 + *） means 0
                    // ((letter + *) = letter || p[j-1] is .)
                    boolean possible2 = (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.') && dp[i-1][j];
                    dp[i][j] = possible1 || possible2;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        isMatch(s, p);
    }
}
