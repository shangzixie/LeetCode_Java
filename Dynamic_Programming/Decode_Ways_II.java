package LeetCode_Java.Dynamic_Programming;

public class Decode_Ways_II {
    public int numDecodings(String s) {
        if (s.length() == 0 || s == null || s.charAt(0) == '0') return 0;
        int n = s.length();

        int pre = 1;
        int cur = 1;
        for (int i = 1; i < n; i++){
            int temp = cur;


            if (s.charAt(i) == '*'){
                if (s.charAt(i-1) == '1') cur += pre + 18;
                if (s.charAt(i-1) == '2') cur += pre + 15;
                if (s.charAt(i-1) == '0') cur = pre + 9;
                if (s.charAt(i-1) == '*') cur += pre + 26;
                else cur += 9;

            }else if (s.charAt(i) == '0'){
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2' ||s.charAt(i-1) == '*') cur = pre;
                else return 0;

            }else{
                if (s.charAt(i-1) == '0' || Integer.valueOf(s.substring(i-1, i+1)) > 26) cur = pre;
                else{
                    if (s.charAt(i-1) != '*') cur += pre;
                    else{
                        if (s.charAt(i-1) > 6) cur += pre + 1;
                        else cur += pre + 2;
                    }
                }

            }



            pre = temp;
        }
        return cur;
    }
}
