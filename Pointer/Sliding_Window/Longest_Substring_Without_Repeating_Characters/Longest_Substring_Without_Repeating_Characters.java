package LeetCode_Java.Pointer.Sliding_Window.Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;

public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int slow = 0, fast = 0;
        int res = Integer.MIN_VALUE;
        HashSet<Character> set = new HashSet<>();


        while (fast < s.length() && slow < s.length()){
            if (!set.contains(s.charAt(fast))){
                set.add(s.charAt(fast));
                fast++;
                res = Math.max(fast - slow, res);
            }else{
                set.remove(slow);
                slow++;
            }
        }
        return res;

    }
}
