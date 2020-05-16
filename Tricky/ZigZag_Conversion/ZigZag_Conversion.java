package LeetCode_Java.Tricky.ZigZag_Conversion;

public class ZigZag_Conversion {
    public String convert(String s, int numRows) {
        // Write your code here
        if (numRows <= 1) return s;


        String[] sb = new String[numRows];

        for (int i =0; i < sb.length; i++) sb[i] = ""; // or it will said null pointer Exception

        for (int i = 0; i < s.length(); i++){
            int index = i % (2 * numRows - 2);
            index = index < numRows? index : (2 * numRows - 2 - index);
            sb[index] += s.charAt(i);
        }
        for (int i = 1; i < sb.length; i++){
            sb[0] += sb[i];
        }
        return sb[0];
    }
}
