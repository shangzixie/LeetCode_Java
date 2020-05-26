package LeetCode_Java.Recursion.Four_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Four_Sum {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        Arrays.sort(numbers);
        boolean[] visited = new boolean[numbers.length];

        helper(numbers, target, new LinkedList<Integer>(), 0, visited);
        return results;
    }

    private void helper(int[] numbers, int target, LinkedList<Integer> path, int startIndex, boolean[] visited){
        if (startIndex >= numbers.length && target != 0) return;
        if (path.size()== 4 && target != 0) return;
        if (path.size() == 4 && target == 0){
            results.add(new LinkedList(path));
            return;
        }

        for (int i = startIndex; i < numbers.length; i++){
            if (i > 0 && numbers[i] == numbers[i-1] && visited[i-1] == false) continue;

            path.add(numbers[i]);
            visited[i] = true;

            helper(numbers, target - numbers[i], path, i + 1, visited);

            visited[i] = false;
            path.removeLast();
        }
    }
}
