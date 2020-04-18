package LeetCode_Java.Java_Basic;

import java.util.Arrays;

public class Regex {
    public static void main(String[] args) {
        String string = "abc def/fds,asdf ";

        String[] strings = string.split("\\W");
        System.out.println(Arrays.toString(strings));
    }
}
