package LeetCode_Java;

import LeetCode_Java.Two_Pointer.Minimum_Window_Substring;

public class deBug {
    public static void main(String[] args) {
        Minimum_Window_Substring a = new Minimum_Window_Substring();
        String source = "ADOBECODEBANC";
        String target = "ABC";
        System.out.println(a.minWindow(source, target));
    }
}
