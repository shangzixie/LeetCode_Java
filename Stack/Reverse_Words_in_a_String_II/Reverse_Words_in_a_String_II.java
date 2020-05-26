package LeetCode_Java.Stack.Reverse_Words_in_a_String_II;

import java.util.LinkedList;

public class Reverse_Words_in_a_String_II {
    public static char[] reverseWords(char[] str) {
        LinkedList<String> stack = new LinkedList<>();
        int i =0;
        String s = "";

        while(i < str.length){
            while (i < str.length && str[i] != ' '){
                s += str[i];
                i++;
            }

            stack.add(s);
            s = "";
            i++;
        }

        String s2 = "";
        while (!stack.isEmpty()){
            s2 += stack.removeLast();
            s2 += " ";
        }

        return s2.substring(0, s2.length()-2).toCharArray();

    }

    public static void main(String[] args) {
        String string = "zpetg pufmm";
        char[] print = reverseWords(string.toCharArray());
        System.out.println(print);
    }
}
