package LeetCode_Java.Two_Pointer;

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
        int matchLen = 0, minLen = Integer.MAX_VALUE, start = 0, index = 0, end = 0;

        //store all target character to map;
        for (char c: target.toCharArray()) charToFreq.put(c, charToFreq.getOrDefault(c, 0) + 1);


        while (end <  source.length()){
            char c = source.charAt(end);
            if (charToFreq.containsKey(c)) {
                charToFreq.put(c, charToFreq.get(c) - 1);
                if (charToFreq.get(c) == 0) matchLen++;
            }
            end++;

            while (matchLen == charToFreq.size()){
                if (minLen > end - start){
                    minLen = end - start;
                    index = start;
                }
                char tempc = source.charAt(start);
                if (charToFreq.containsKey(tempc)){
                    charToFreq.put(tempc, charToFreq.get(tempc) + 1);
                    if (charToFreq.get(tempc) > 0) matchLen --;
                }

                start ++;
            }

        }
        return minLen == Integer.MAX_VALUE ? "" : source.substring(index, index + minLen);
    }

}
