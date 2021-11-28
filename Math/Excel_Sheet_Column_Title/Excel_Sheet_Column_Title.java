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

/*
This is a math question.

how to conversion from a 26 进制 to decimal?

ABZ = 1*26² + 2 * 26¹ + 26*26°= 676 + 52 + 26 = 754


https://xinghao-huang-portfolio.herokuapp.com/year/01/02/LeetCode/168.%20Excel%20Sheet%20Column%20Title/#problem

*/