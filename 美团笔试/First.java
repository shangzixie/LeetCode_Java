package LeetCode_Java.美团笔试;

import java.util.HashMap;
import java.util.Scanner;



/*
某学校的期末考试共有n个学生参加，考试科目共有m科。学校将会给一部分学生颁发单科成绩优秀奖，获奖学生需要满足的条件是某一科的成绩是所有学生中最高的或是最高的之一。

请问学校应该给多少名学生颁发单科成绩优秀奖。

输入
输入第一行包含两个正整数n和m，分别代表学生人数和考试科目数量。(n,m<=500)

接下来有n行，每行有m个正整数，每个正整数在1-100之间，中间用空格隔开，表示每个学生的m科考试成绩。

输出
输出仅包含一个整数，表示获得单科成绩优秀奖的人数


样例输入
5 5
28 35 38 10 19
4 76 72 38 86
96 80 81 17 10
70 64 86 85 10
1 93 19 34 41
样例输出
4

提示
注意，输出结果为人数，并非人次。同一个学生如有多科最优，获奖人数也只会计为1人，即输出结果始终小于等于n
 */
public class First {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.next());
        int m = Integer.valueOf(sc.next());
        HashMap<Integer, Integer> map = new HashMap();

        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                nums[i][j] = sc.nextInt();
            }
        }

        for (int j = m-1; j >=0 ; j--){
            int max = Integer.MIN_VALUE;
            int person = 0;
            for (int i = 0; i < n; i++){
                if (nums[i][j] > max){
                    max = nums[i][j];
                    person = i;
                }

            }
            map.put(person, max);
        }
        int ans = 0;
        for (int i = 0; i <n ;i++){
            if (map.containsKey(i)) ans++;
        }

        System.out.println(ans);


    }
}
