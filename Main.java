package LeetCode_Java;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        ArrayList<ArrayList<Integer>> nums = new ArrayList<>();

        while (a != 0 && b != 0){
            ArrayList<Integer> num = new ArrayList<>();
            num.add(a);
            num.add(b);
            nums.add(num);
            a = sc.nextInt();
            b = sc.nextInt();
        }

        for (ArrayList<Integer> num : nums){
            long N = num.get(0);
            long L = num.get(1);
            long res =0;

            for (int i = 1; i <= L; i++){
                res += compute(N, i) % 1000000007;
            }

            System.out.println(res% 1000000007);
        }
    }

    private static double compute(long N, long i){
        double res = 1;
        N = N % 1000000007;
        for(; i !=0; i /= 2){
            if (i %2 == 1){
                res = res * N % 1000000007;
            }
            N = N * N % 1000000007 ;
        }
        return res;

    }
}
