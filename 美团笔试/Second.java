package LeetCode_Java.美团笔试;

import java.util.HashSet;
import java.util.Scanner;



/*
题目描述：
有这么一段伪代码

input a,b,m,x

while true:

  x=(a*x+b)%m

  print(x)

end while

输出的x由于是在取模意义下的，所以会出现循环。

比如，a=2, b=1, m=5, x=2的时候，输出的序列将会如下：

0,1,3,2,0,1,3,2,0,1,3,2....

其中：0,1,3,2 称为最短的循环节。

现在给定a,b,m,x的值，请你计算最短循环节的长度。

输入
输入4个数，a,b,m,x

输出
输出一个数，最短循环节的长度


样例输入
2 1 5 2
样例输出
4

提示
1≤a,b,x≤m≤100000 ,a,b,x,m均为正整数

 */
public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();
        long x = sc.nextInt();

        HashSet<Long> set = new HashSet<>();
        while(true){
            x = (a*x+b)%m;
            if (!set.contains(x)) set.add(x);
            else break;

        }
        System.out.println(set.size());

    }
}
