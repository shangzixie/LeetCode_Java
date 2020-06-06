package LeetCode_Java.DFS.Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {

    List<String> results = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        int left = n, right = n;
        helper(left, right, "");

        return results;
    }

    public void helper(int left, int right, String path){
        if (left < 0 || right < 0 || left > right) return;
        if (left == 0 && right == 0){
            results.add(path);
            return;
        }

        //add left
        helper(left - 1, right, path + "(");
        //add right
        helper(left, right - 1, path + ")");
    }
}
