package LeetCode_Java.Tricky.Valid_Sudoku;

import java.util.HashSet;

public class Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    String row = "" + i + "row" + board[i][j];
                    String col = "" + j + "col" + board[i][j];
                    String matr = "" + i/3 + j/3 + "matr" + board[i][j];
                    if (set.contains(row) || set.contains(col) || set.contains(matr)){
                        return false;
                    }
                    set.add(row);
                    set.add(col);
                    set.add(matr);

                }
            }
        }
        return true;
    }
}
