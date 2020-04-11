package LeetCode_Java.Pointer.Valid_Palindrome;

import static java.lang.Character.isLetter;

public class Valid_Palindrome {
    public static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right){
            while(left <right && (!Character.isLetter(chars[left]) && !Character.isDigit(chars[left]))){
                left++;
            }
            while(left < right && (!Character.isLetter(chars[right]) && !Character.isDigit(chars[right]))){
                right--;
            }

            if (Character.toLowerCase(chars[left]) == Character.toLowerCase(chars[right])){
                left ++;
                right --;
            }else{
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s= "A man, a plan, a canal: Panama";
        isPalindrome(s);
    }
}
