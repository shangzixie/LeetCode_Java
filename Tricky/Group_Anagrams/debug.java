package Tricky.Group_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class debug {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] counts = new char[26];

            for (int i = 0; i < s.length(); i++) {
                counts[s.charAt(i) - 'a']++;
            }

            String keyStr = String.valueOf(counts);

            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }

    }
        // sort



}
