package LeetCode_Java.Pointer.One_Edit_Distance;

public class One_Edit_Distance {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) return false;
        if (s.length() - t.length() >= 2 || s.length() - t.length() <= -2) return false;
        if (s.length() < t.length()) return isOneEditDistance(t, s);


        int count = 0;
        if (s.length() == t.length()){
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) != t.charAt(i)){
                    count ++;
                }

            }
            return count <=1 ? true:false;
        }else{
            int i = 0, j = 0;
            while (i < s.length()){
                if (j < t.length() && s.charAt(i) == t.charAt(j)){
                    i++;
                    j++;
                }else{
                    i++;
                    count++;
                }
            }
            return count<=1?true:false;

        }


    }
}
