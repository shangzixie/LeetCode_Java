package LeetCode_Java.Math.Pow;

public class myPow {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }
        if(n < 0) return myPow(1/x, -n);


        return (n % 2 == 0) ? myPow(x * x, n/2) : x *  myPow(x * x, n/2);
    }
}
