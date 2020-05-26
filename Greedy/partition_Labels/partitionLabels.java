package LeetCode_Java.Greedy.partition_Labels;

import java.util.ArrayList;
import java.util.List;

public class partitionLabels {
    public List<Integer> partitionLabels(String s) {
        // Write your code here
        int[] last = new int[26];
        for (int i = 0;i < s.length();i++ ){
            last[s.charAt(i) - 'a'] = i;
        }

        int maxRight = 0;
        int num = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            maxRight = Math.max(maxRight, last[s.charAt(i) - 'a']);

            if (i <maxRight){
                num++;
            }else if (i == maxRight){
                num++;
                ans.add(num);
                num = 0;
            }
        }
        return ans;
    }

    ////////////////////////////after modify////////////////////
    public List<Integer> partitionLabels1(String s) {
        // Write your code here
        int[] last = new int[26];
        for (int i = 0;i < s.length();i++ ){
            last[s.charAt(i) - 'a'] = i;
        }

        int maxRight = 0;
        int num = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            maxRight = Math.max(maxRight, last[s.charAt(i) - 'a']);
            num++;
            if (i == maxRight){
                ans.add(num);
                num = 0;
            }
        }
        return ans;
    }
}
