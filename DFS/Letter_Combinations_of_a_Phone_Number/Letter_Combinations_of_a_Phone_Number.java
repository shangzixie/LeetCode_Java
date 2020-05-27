package LeetCode_Java.DFS.Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;



public class Letter_Combinations_of_a_Phone_Number {
    String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> results = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        // write your code here
        helper(digits, 0, "");
        return results;
    }
    public void helper(String digits, int index, String path){
        if (index == digits.length()){
            results.add(path);
            return;
        }
        //"23"
        int lettersIndex = digits.charAt(index) - '0';
        String s = letters[lettersIndex];
        for (int i = 0; i < s.length(); i++){
            helper(digits, index + 1, path + s.charAt(i));
        }
    }
}
