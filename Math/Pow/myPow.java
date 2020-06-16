package Math.Pow;

public class myPow {
    //recursion
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }
        if(n < 0) return myPow(1/x, -n);


        return (n % 2 == 0) ? myPow(x * x, n/2) : x *  myPow(x * x, n/2);
    }
    //iterator
    public double myPow1(double x, int n) {
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b % 2) != 0) res *= x; // terminal condition: b == 1, res will record the final ans.
            x *= x;
            b /= 2;
        }
        return res;
    }
}
