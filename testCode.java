import Math.Permutation_Sequence.Permutation_Sequence;

public class testCode {
    public static void main(String[] args) {
        int n = 100;
        int res = 0;
        while(n>2){
            res += n/3;
            n = n/3+n%3;
        }
        if(n==2) res+=1;

        System.out.println(res);



    }
}
