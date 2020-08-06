import LeetCode_Java.buildinClass.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    static List<List<Integer>> ans;
    public  static List<List<Integer>> answer(int n, int sum){
        ans = new ArrayList<>();
        dfs(n, sum, new ArrayList<>());
        return ans;
    }
    private static void dfs(int n, int sum, List<Integer> path) {
        if (n == 0) {
            if (sum == 0) ans.add(new ArrayList<>(path));
            return;
        }

        // choose current
        path.add(n);
        dfs(n - 1, sum - n, path);
        path.remove(path.size() - 1);
        // not choose current
        dfs(n - 1, sum, path);
    }

    public static void main(String[] args) {
        int n = 5;
        int sum = 8;
        System.out.println(answer(n, sum));
    }

}
