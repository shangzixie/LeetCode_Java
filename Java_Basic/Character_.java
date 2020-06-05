package LeetCode_Java.Java_Basic;

public class Character_ {
    public static void main(String[] args) {
        String s= "abcd123[]";
        for (int i =0; i < s.length();i++){
            System.out.println(Character.isAlphabetic(s.charAt(i)));
            System.out.println(Character.isDigit(s.charAt(i)));
            System.out.println("--------------------");
        }
    }
}

