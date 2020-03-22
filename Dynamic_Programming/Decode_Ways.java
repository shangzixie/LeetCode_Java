package LeetCode_Java.Dynamic_Programming;

import java.util.HashMap;
import java.util.Map;

public class Decode_Ways {
    // memo method
    public static Map<String, Integer> map = new HashMap<>();
    public static int numDecodings1(String s) {
        if (s.length() ==0) return 0;
        return backTrack(s);
    }

    private static int backTrack(String s){
        if (map.containsKey(s)) return map.get(s);
        if (s.length() > 0 && s.charAt(0) == '0') return 0;
        if (s.length() <= 1 ) return 1;


        // remove the first digit
        int w = backTrack(s.substring(1));
        // remove the first two digits
        String front = s.substring(0, 2);
        int t = Integer.valueOf(front);
        if (t <= 26) w += backTrack(s.substring(2));

        map.put(s, w);
        return w;
    }
/////////////////////////////////////////Dp Method//////////////////////////////////

    public static int numDecodings(String s){
        if (s.length() == 0 || s == null || s.charAt(0) == '0') return 0;
        int n = s.length();

        int pre = 1;
        int cur = 1;
        for (int i =2; i < n; i++){
            int temp = cur;
            if (s.charAt(i) != '0'){
                if (s.charAt(i-1) != '0' && Integer.valueOf(s.substring(i-1, i+1)) <=26) cur += pre;
                else cur = cur; //could remove
            }else{
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') cur = pre;
                else return 0;
            }
            pre = temp;
        }
        return cur;
    }














    public static void main(String[] args) {
        String s = "12";
        numDecodings1(s);
    }
}
