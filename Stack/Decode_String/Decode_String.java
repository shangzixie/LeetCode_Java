package LeetCode_Java.Stack.Decode_String;



import java.util.LinkedList;

public class Decode_String {
    public String decodeString(String s) {
        if (s.length() == 0) return "";

        LinkedList<String> stack = new LinkedList<>();
        String ans = "", preString = "", curNum = "";

        for (int i = 0;i< s.length();i++ ){
            char cur = s.charAt(i);
            //current is number
            if (Character.isDigit(cur)) curNum += cur;
                //current is letter
            else if (Character.isLetter(cur)) ans += cur;

            else if (cur == '['){
                //every time we need to append string then num so as to pop num first
                stack.add(ans);  // stack format:[string, num, string, num....]
                stack.add(curNum);
                ans = "";
                curNum = "";

            }else{ // if cur == ']'
                int num = Integer.valueOf(stack.removeLast()); //num will be pop at first
                preString = stack.removeLast();   // then  string will be pop
                // ans = preString + ans * num
                ans = preString + ans.repeat(num);
            }
        }
        return ans;
    }
}
