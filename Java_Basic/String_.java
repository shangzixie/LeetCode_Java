package Java_Basic;

public class String_ {
    public static void main(String[] args) {
     // StringBuilder/ StringBuffer

        StringBuilder str = new StringBuilder();

        //增
        str.append("a");
        str.append("b");
        str.append("c");
        str.append("d");
        str.append("e");
        str.append("f");
        str.append("f");




        //查
        str.charAt(3);
        str.length();


        //删
        str.deleteCharAt(5);
        str.delete(3,4);


        // to string
        str.toString();
        //reverse
        str.reverse();




    //string

        //转换为StringBuilder 用append或者放进括号
        String s = "abcd";
        StringBuilder sb = new StringBuilder(s); //或者 sb.append(s);
        System.out.println(sb);

        //repeat
        String str1 = "abc";
        // String repeated = str1.repeat(3); // it will return "abcabcabc";

        // isLetter, isDigit
        String ss = "abc123";
        Character.isLetter(ss.charAt(0));
        Character.isDigit(ss.charAt(0));

    }
}
