package LeetCode_Java.Tree;



public class Surrounded_Regions {
    // method 1: wrong
    /*
    common dfs will cause a serious problem:
   input:
    ["XXXXX",
     "XXXXX",
     "XXOOX",
     "XXOXX",
     "XXOXX"]

     output:
    ["XXXXX",
     "XXXXX",
     "XXOxX",
     "XXOXX",
     "XXOXX"]   but it is wrong
 */
    public void surroundedRegions1(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (visited[i][j] || board[i][j]== 'X') continue;
                dfs1(board, i, j, visited);
            }
        }
    }

    public boolean dfs1(char[][] board,int i,int j, boolean[][] visited){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] == 'X' || visited[i][j] == true ) return true;

        visited[i][j] = true;
        boolean up = dfs1(board, i-1, j, visited);
        boolean down = dfs1(board, i + 1, j, visited);
        boolean left = dfs1(board, i, j-1, visited);
        boolean right = dfs1(board, i, j+ 1, visited);

        if (up && down && left && right){
            board[i][j] = 'X';
            return true;
        }
        return false;
    }
////////////////////////////////method 2:  dfs from boundary///////////////////////////////////////////////////////////////////

    public void surroundedRegions(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    if (board[i][j] == 'O' && visited[i][j] == false) dfs(board, i, j, visited);
                }
            }
        }

        for (int i =0 ; i < m; i ++){
            for (int j = 0; j< n; j++){
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'F') board[i][j] = 'O';
            }
        }
    }
    public void dfs(char[][] board, int i, int j, boolean[][] visited){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (visited[i][j] || board[i][j] == 'X') return;

        visited[i][j] = true;
        board[i][j] = 'F';
        dfs(board, i, j + 1, visited);
        dfs(board, i, j - 1, visited);
        dfs(board, i + 1, j, visited);
        dfs(board, i - 1, j, visited);
    }
}
