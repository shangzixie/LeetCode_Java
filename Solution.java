import LeetCode_Java.buildinClass.TreeNode;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public  static List<Integer> meanderingArray(List<Integer> unsorted){
        Integer[] arr = new Integer[unsorted.size()];
        for (int i = 0; i < unsorted.size(); i++) {
            arr[i] = unsorted.get(i);
        }
        Arrays.sort(arr);

        int maxIndex = arr.length - 1, minIndex = 0;
        int max = arr[unsorted.size() - 1] + 1;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] += (unsorted.get(maxIndex) % max) * max;
                maxIndex--;
            } else {
                arr[i] += (unsorted.get(minIndex) % max) * max;
                minIndex--;
            }
        }
        return Arrays.asList(arr);


    }

}
