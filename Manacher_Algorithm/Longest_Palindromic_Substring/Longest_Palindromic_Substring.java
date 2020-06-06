package LeetCode_Java.Manacher_Algorithm.Longest_Palindromic_Substring;

public class Longest_Palindromic_Substring {
    public String longestPalindrome1(String s) {
        // method 1: T(n) = O(n^2)   two pointer;
        if (s.length() == 1) return s;

        int ans = Integer.MIN_VALUE;
        int startIndex = -1;
        for (int i = 0; i < s.length() ; i++ ){  // attention: need to consider odd and
            // odd
            int length = findPa(i, i, s);
            if (ans < length){
                ans = length;
                startIndex = i - (length / 2);
            }


            //even
            length = findPa(i, i+1, s);
            if (ans < length){
                ans = length;
                startIndex = i - (length / 2) + 1;
            }
        }
        System.out.println(startIndex);
        return s.substring(startIndex, startIndex + ans);

    }

    public int findPa(int left, int right, String s){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
    //------------------------------------Manacher Algorithm------------------------------//
    public String longestPalindrome(String s) {
        Manacher_Algorithm_Code a = new Manacher_Algorithm_Code();
        return a.longestPalindrome(s);
    }
}
