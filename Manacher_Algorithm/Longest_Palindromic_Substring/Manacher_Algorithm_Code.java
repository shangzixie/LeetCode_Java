package LeetCode_Java.Manacher_Algorithm.Longest_Palindromic_Substring;

public class Manacher_Algorithm_Code {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;


        String str = generateString(s);

        int[] p = new int[str.length()]; // Auxiliary array
        int center = 0, maxRight = 0;  // two variables
        int maxLen = 1, start = 0;  //global max length and its start index


        for (int i = 0; i < str.length(); i++){
            // update p[i]
            if (i < maxRight){
                int mirror = center - (i - center);
                p[i] = Math.min(maxRight - i, p[mirror]);
            }
            // try to expands p[i] and the range of maxRight;
            // left and right pointer could jump to unknown fields by above p[i]
            int left = i - (1 + p[i]), right = i + (1 + p[i]);
            while (left >=0 && right < str.length() && str.charAt(left) == str.charAt(right)){
                p[i]++;
                left--;
                right++;
            }
            //update the maxRight
            if (i + p[i] > maxRight){
                maxRight = i + p[i];
                center = i;
            }
            if (p[i] > maxLen){
                maxLen = p[i];
                start = (i - maxLen) / 2;
            }


        }
        return s.substring(start, start + maxLen);
    }
    private String generateString(String s){
        StringBuffer sb = new StringBuffer();
        for (int i =0; i < s.length(); i++){
            sb.append('#');
            sb.append(s.charAt(i));
        }

        sb.append('#');
        return sb.toString();
    }

}
