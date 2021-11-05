
package LeetCode_Java.Pointer.Three_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        int left = 0, right = numbers.length - 1;
        Arrays.sort(numbers);


        for (int i = 0; i < numbers.length; i++){
            if (i > 0 && numbers[i] == numbers[i-1]) continue;
            twoSum(i + 1, numbers.length - 1, -numbers[i], numbers, results);
        }
        return results;

    }

    private void twoSum(int start, int end, int target, int[] nums, List<List<Integer>> results){
        List<Integer> triplets = new ArrayList<>();

        while (start < end){
            if (nums[start] + nums[end] < target){
                start++;
            }else if (nums[start] + nums[end] > target){
                end--;
            }else{

                if (results.size() != 0 && results.get(results.size()-1).get(1) == nums[start] && results.get(results.size()-1).get(2) == nums[end]) {
                    start++;
                    end--;
                    continue;
                }
                triplets.add(-target);
                triplets.add(nums[start]);
                triplets.add(nums[end]);
                results.add(triplets);
                triplets = new ArrayList<>();
                start++;
                end--;
            }
        }
    }
}
