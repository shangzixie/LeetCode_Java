package LeetCode_Java.美团笔试;

import java.util.Arrays;
import java.util.Scanner;

/*
n个数的伪中位数定义为从小到大排序后第⌊(n+1)/2⌋个数。其中，⌊x⌋的意思是x向下取整。

现在，给你n个数，你需要向其中增加最少的数，使得k成为最后这一组数的伪中位数。

请问你需要加入数的最少数。

输入
输入第一行包含两个数n,k,意为原来数的个数和最后的伪中位数。

接下来一行n个数a_i，空格隔开，代表原来的数。

1≤n≤500,1≤a_i≤100000

输出
输出一个数，你需要加入数的最少数量。


样例输入
4 2
2 3 3 3
样例输出
2

提示
样例解释：加入1,1后,原数组变为1,1,2,3,3,3,其伪中位数为2。
 */
public class Forth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        if(n == 0) System.out.println(0);

        int[] nums = new int[n];
        for (int i =0 ; i < n; i++){
            nums[i] = sc.nextInt();
        }



        int index = -1;
        for (int i = 0; i < n; i++){
            if (nums[i] == k){
                index = i;
                break;
            }
        }

        System.out.println(n - index * 2 - 2);
    }
}
