package LeetCode_Java.Math.Number_Of_1_Bites;

public class Number_Of_1_Bites {
    public int hammingWeight(int n) {
        // write your code here
        int count = 0;
        while(n != 0){
            count += (n & 1);
            n = n >> 1;
        }
        return count;
    }
}
