package LeetCode_Java.Pointer.Sliding_Window.Minimum_Window_Substring_II;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring_II {
    /**
    * @param S: A source string
    * @param T: A target string
    * @return: The String contains the smallest substring of all T letters.
    */
    public static String minWindowII(String S, String T) {
        String source = S + S;
        String target = T;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, index = 0, minLen = Integer.MAX_VALUE, matchLen = 0;

        // handle the hashmap
        for (char c: target.toCharArray()) map.put(c, map.getOrDefault(c, 0) +1 );

        // move end
        while (end < source.length()){
            char c = source.charAt(end);
            if (map.containsKey(c)){
                map.put(c, map.get(c) -1);
                if (map.get(c) == 0) matchLen += 1;
            }
            end += 1;
            String cur = source.substring(start, end);
            //move start
            while (matchLen == map.size()){
                if (minLen >= end - start){  // bug1: this is end - start  not start - end!!
                    minLen = end - start;
                    index = start;
                }
                char tempc = source.charAt(start);
                if (map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) +1);
                    if (map.get(tempc) > 0) matchLen -= 1;
                }
                start += 1;
            }
        }


        return minLen == Integer.MAX_VALUE ? "" : source.substring(index, minLen + index);
    }

    public static void main(String[] args) {
        String s = "abcdc";
        String t = "da";
        String result = minWindowII(s, t);
        System.out.println(result);
    }

}

