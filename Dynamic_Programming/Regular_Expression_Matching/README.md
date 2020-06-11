# 10. Regular Expression Matching

[LeetCode 10](https://leetcode.com/problems/regular-expression-matching/)


## Methods

### Method 1
example:
``` 
index           i1  i2  ...........i3
s:  c   c   d   f   a   a  a  a... a

t:  c  c  d  f  a   *
index               j    

```
`1.` `*` denotes 0 letter: 

```
index           i1  
s:  c   c   d   f  

t:  c  c  d  f  a   *
index               j  

```
`dp[i1][j] = dp[i1][j-2]`  `->formula (1)`



`2.` `*` denotes 1 letter: 
``` 
index           i1  i2  
s:  c   c   d   f   a   

t:  c  c  d  f  a   *
index               j    

```
```
dp[i2][j] = 
(s[i2] == t[j-1])  &&  (dp[i2 - 1][j]) = 
(s[i2] == t[j-1])  &&  (dp[i1][j]) = 
(s[i2] == t[j-1])  &&  formula (1)

-> summary (s[i] == t[j-1])  &&  formula (1) 
```

`3.` `*` denotes many letters: 

``` 
index           i1  i2  ...........i3
s:  c   c   d   f   a   a  a  a... a

t:  c  c  d  f  a   *
index               j    

```
```
dp[i3][j] = 
(s[i3] == t[j-1])  && (dp[i3-1][j]) =
(s[i3] == t[j-1])  && (dp[i3-2][j]) =
(s[i3] == t[j-1])  && (dp[i3-3][j]) =
....
(s[i3] == t[j-1])  &&  (dp[i2][j]) = 
(s[i3] == t[j-1])  &&  (dp[i2 - 1][j]) = 
(s[i3] == t[j-1])  &&  (dp[i1][j]) = 
(s[i3] == t[j-1])  &&  formula (1) = 

-> summary (s[i] == t[j-1])  &&  formula (1) 

```

so if `*` denotes 0 letter -> `dp[i][j] = dp[i-1][j-2]`

   if `*` denotes 1 or more letters -> `dp[i][j] = dp[i-1][j] && s[i] == t[j-1]`

### Key Points


### Code
```java
public class Regular_Expression_Matching {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        s = "#" + s;
        p = "#" + p;

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for (int j = 2; j < n + 1; j++){
            dp[0][j] = (p.charAt(j) == '*') && dp[0][j-2];
        }


        for (int i = 1;i < m + 1 ; i++){
            for (int j = 1; j < n + 1; j++) {
                if (Character.isLetter(p.charAt(j))){
                    dp[i][j] = ((s.charAt(i) == p.charAt(j))) && dp[i-1][j-1];
                }else if (p.charAt(j) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }else if (p.charAt(j) == '*'){
                    boolean possible1 = dp[i][j-2];  // （字母 + *） means 0
                    // ((letter + *) = letter || p[j-1] is .)
                    boolean possible2 = (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.') && dp[i-1][j];
                    dp[i][j] = possible1 || possible2;
                }
            }
        }
        return dp[m][n];
    }
}

```


## Reference