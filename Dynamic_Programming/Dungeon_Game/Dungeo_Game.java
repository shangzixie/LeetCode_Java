package LeetCode_Java.Dynamic_Programming.Dungeon_Game;

public class Dungeo_Game {
    public  int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];


        for (int i = m -1; i >= 0; i--){
            for (int j = n - 1; j >= 0; j--){
                if (i == m -1 && j == n -1){
                    dp[i][j] = 1; //右下角初始值
                }else if(i == m - 1){
                    dp[m-1][j] = dp[m-1][j+1] -dungeon[m-1][j+1]; //下边界
                }else if (j == n -1){
                    dp[i][n-1] = dp[i+1][n-1] - dungeon[i+1][n-1]; //右边界
                }else{
                    dp[i][j] = Math.min(dp[i][j+1] - dungeon[i][j+1], dp[i+1][j] - dungeon[i+1][j]);
                }
                dp[i][j] = Math.max(1, dp[i][j]);
            }
        }

        //don't forget the dungeon[0][0]
        dp[0][0] = Math.max(dp[0][0] - dungeon[0][0], 1);



        return dp[0][0];
    }

}
