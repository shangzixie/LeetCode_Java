package LeetCode_Java.Math.Excel_Sheet_Column_Title;

public class Excel_Sheet_Column_Title {
    public static String convertToTitle(int n) {
        String ans = "";

        while (n > 0){
            n--;
            ans += (char)(n % 26 + 'A') ;
            n /= 26;
        }
        return new StringBuilder(ans).reverse().toString();



    }

    public static void main(String[] args) {
        int n = 1000;
        convertToTitle(n);
    }

}
