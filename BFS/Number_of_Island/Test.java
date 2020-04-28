package LeetCode_Java.BFS.Number_of_Island;

public class Test {
    public static void main(String[] args) {
        boolean[][] grid = {{true,true,false,false,false},{false,true,false,false,true},{false,false,false,true,true},{false,false,false,false,false},{false,false,false,false,true}};
        Number_of_Island a = new Number_of_Island();
        a.numIslands(grid);
    }
}
