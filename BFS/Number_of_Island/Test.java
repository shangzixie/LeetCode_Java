package BFS.Number_of_Island;

public class Test {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        Number_of_Island a = new Number_of_Island();
        a.numIslands(grid);
    }
}
