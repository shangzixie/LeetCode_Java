package LeetCode_Java;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());

        for (; t >= 0; t--){
            int n = sc.nextInt();
            String num = sc.nextLine();
            char[] chars = num.toCharArray();

            for (int i =0; i <= n -2; i++){
                if (chars[i] == '1' && chars[i+ 1] =='1') continue;
                else if(chars[i] == '0' && chars[i+1] =='0') chars[i] = '1';
                else if(i <= n-2 && chars[i] == '0' && chars[i+1] == '1' && chars[i + 2] == '0'){
                    chars[i] = '1';
                    chars[i+1] = '0';
                    chars[i+2] = '0';
                }
            }
            System.out.println(new String(chars));
        }

    }
}
