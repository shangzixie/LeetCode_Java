package LeetCode_Java;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[9][9];

        for(int i = 0; i < 9; i++){
            String row = sc.nextLine();
            for (int j = 0; j < 9; j++){
                board[i][j] = row.charAt(j* 2 +1) - '0';
            }
        }

        dfs(board, 0, 0);

        for (int x = 0; x < 9; x++){
            System.out.println("{");
            for (int y = 0; y < 8; y++ ){
                System.out.println(board[x][y] + ",");
            }
            if (x < 8) System.out.println(board[x][8] +"}");
            else System.out.print(board[x][8] +"}");
        }

    }

    public static boolean dfs(int[][] board, int i, int j ){
        if (i ==9 && j ==0) return true;

        int next_i;
        int next_j;

        if (j==8) {
            next_i = i + 1;
            next_j = 0;
        }else{
            next_i = i;
            next_j = j+1;
        }

        if (board[i][j] != 0) return dfs(board, next_i, next_j);

        for (int c = 1; c< 10; c++){
            if (!isValid(board, i , j, c)) continue;
            board[i][j] = c;
            if (dfs(board,next_i, next_j)) return true;

            board[i][j] =0;

        }
        return false;
    }

    public static boolean isValid(int[][] board, int cur_x, int cur_y, int num){
        for (int index = 0; index < 9; index++){
            if (board[cur_x][index] == num || board[index][cur_y] == num) return false;

            int row = cur_x / 3 * 3 + index /3;
            int column = cur_y / 3 * 3 + index % 3;
            if (board[row][column] == num) return false;
        }
        return true;
    }
}
