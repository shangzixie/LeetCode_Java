import Math.Permutation_Sequence.Permutation_Sequence;

public class testCode {
    private int i = 1;
    private int j = 2;

    public testCode(int var){
        System.out.println(i);
        System.out.println(j);
        this.i = var;
        System.out.println(i);
        System.out.println(j);
    }

    {               // 实例代码块
        j += 3;

    }

    public static void main(String[] args) {
        new testCode(8);
    }

}
