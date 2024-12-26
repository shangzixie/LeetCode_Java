# [LeetCode 186. Reverse Words in a String II](https://leetcode-cn.com/problems/reverse-words-in-a-string-ii/)

## Methods

### Method 1

* `Time Complexity`: O(n)
* `Intuition`: in place, reverse many times
* `Key Points`:
* `Algorithm`:

两次翻转即可，第一次全局翻转，第二次翻转各个单词

### Code

* `Code Design`:

```java
func reverseWords(s []byte)  {
    if len(s)  <= 1 {
        return
    }
    reverse(s, 0, len(s) - 1)
    left := 0
    for i, ch := range s {
        if ch == byte(' ') {
            right := i - 1
            reverse(s, left, right)
            left = i + 1
        }
    }
    // 翻转最后一个单词
    reverse(s, left, len(s) - 1)
}

func reverse(s []byte, left int, right int) {
    for left < right {
        s[left], s[right] = s[right], s[left]
        left += 1
        right -= 1
    }
}
```

### Method 2

* `Time Complexity`: O(n)
* `Intuition`: stack
* `Key Points`:
* `Algorithm`:

### Code

* `Code Design`:

```java
package LeetCode_Java.Stack.Reverse_Words_in_a_String_II;

import java.util.LinkedList;

public class Reverse_Words_in_a_String_II {
    public static char[] reverseWords(char[] str) {
        LinkedList<String> stack = new LinkedList<>();
        int i =0;
        String s = "";

        while(i < str.length){
            while (i < str.length && str[i] != ' '){
                s += str[i];
                i++;
            }

            stack.add(s);
            s = "";
            i++;
        }

        String s2 = "";
        while (!stack.isEmpty()){
            s2 += stack.removeLast();
            s2 += " ";
        }

        return s2.substring(0, s2.length()-2).toCharArray();

    }

    public static void main(String[] args) {
        String string = "zpetg pufmm";
        char[] print = reverseWords(string.toCharArray());
        System.out.println(print);
    }
}

```

## Reference
