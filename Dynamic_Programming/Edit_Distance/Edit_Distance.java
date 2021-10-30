package LeetCode_Java.Dynamic_Programming.Edit_Distance;

public class Edit_Distance {
    public int minDistance(String word1, String word2) {
        word1 = "#" + word1;
        word2 = "#" + word2;

        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for (int i =0; i< word1.length(); i++){
            dp[i][0] = i;
        }

        for (int i =0; i< word2.length(); i++){
            dp[0][i] = i;
        }

        for (int i =1; i < word1.length(); i++){
            for (int j = 1; j < word2.length(); j++){
                if (word1.charAt(i) == word2.charAt(j)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
            }
        }
        return dp[word1.length()-1][word2.length()-1];
    }
}
