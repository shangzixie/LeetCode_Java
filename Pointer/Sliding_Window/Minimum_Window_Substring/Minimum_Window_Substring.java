package LeetCode_Java.Pointer.Sliding_Window.Minimum_Window_Substring;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring {
    /*
    bug1:  matchLen操作;
    一个为++ ；
    一个为--;
     */
    public String minWindow(String source , String target) {
        if (source == null || target == null) return "";

        Map<Character, Integer> charToFreq = new HashMap<>();
        int minLen = Integer.MAX_VALUE, start = 0, end = 0, index = 0;

        //store all target character to map;
        for (char c: target.toCharArray()) charToFreq.put(c, charToFreq.getOrDefault(c, 0) + 1);
        int matchLen = charToFreq.size();

        while (end < source.length()){
            char c = source.charAt(end);
            if (charToFreq.containsKey(c)){
                charToFreq.put(c, charToFreq.get(c) - 1);
                if (charToFreq.get(c) == 0) matchLen--;
            }
            while (matchLen <=0){
                if (minLen > end - start +1){
                    minLen = end - start +1;
                    index = start;
                }

                char tempc = source.charAt(start);
                if (charToFreq.containsKey(tempc)){
                    charToFreq.put(tempc, charToFreq.get(tempc) + 1);
                    if (charToFreq.get(tempc) > 0) matchLen++;
                }

                start ++;
            }
            end++;
        }
        return minLen == Integer.MAX_VALUE ? "" : source.substring(index, index + minLen);
    }

}
