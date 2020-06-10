# 72. Edit Distance

[LeetCode 72](https://leetcode.com/problems/edit-distance/)


## Methods
In Double Sequence Problem, basically, the dp meaning has been shown in question description: ` find the minimum number of operations required to convert word1 to word2.`
Always what it asks is the dp. 
 
so dp[i][j] means ` the minimum number of operations required to convert word1[0:i] to word2[0:j]`

### Method 1

**Function**:


`1.`
```
example: 
word1 = abbc    i -> c
word2 = acc     j -> c
```
if `word1[i] == word2[j]`: \
in the example, `the minimum number of operations required to convert word1[0 ~ i] = abbc to word2[0 ~ j] = acc` 
will be decided by `word1[0 ~ i-1]--"abb" and word2[0~j-1]--"ac"` . that is to say `dp[i][j] = dp[i-1][j-1]` 


`2.` if ``word1[i] != word2[j]``:
```
example: 
word1 = abbc    i -> c
word2 = accf    j -> f

```

2.1 Insert:\
in the example above, `the minimum number of operations required to convert word1[0 ~ i] =abbc to word2[0 ~ j] = accf` will be decided by 
`insert f to word1, which become word1 = abbcf ` && `the minimum number of operations required to convert word1[0~i] =abbc to word2[j - 1] = acc` that is to say `dp[i][j] = 1 + dp[i][j -1]`

2.2 Delete:\
`the minimum number of operations required to convert word1[0 ~ i] =abbc to word2[0 ~ j] = accf` will be decided by 
`delete the last letter c` && `the minimum number of operations required to convert word1[0 ~ i-1] =abb to word2[j] = accf` that is to say `dp[i][j] = 1 + dp[i-1][j]`

3.3 Replace:\
`dp[i][j] = dp[i-1][j-1]`

**Terminal Condition or Base Case**
when `word1 = null` or `word2 = null`, `dp = len(the other !null word)`

### Key Points


### Code
```java

public class Solution {
    /**
        why I + "#" for word1 and word2 is if I don't add them, the code will become:
        
        for (int i =1; i < word1.length(); i++){
            for (int j = 1; j < word2.length(); j++){
                need to add if() to deal with i-1 = -1 or j-1 = -1 case  
            }
        }
    */
    public int minDistance(String word1, String word2) {
        //preprocessed data, so as for loop not stagger one 
        word1 = "#" + word1;                          
        word2 = "#" + word2;        
        
        int[][] dp = new int[word1.length()+1][word2.length()+1]; 
        
        for (int i =0; i< word1.length(); i++){
            dp[i][0] = i; 
        }
        
        for (int i =0; i< word2.length(); i++){
            dp[0][i] = i; 
        }
        
        for (int i =1; i < word1.length(); i++){
            for (int j = 1; j < word2.length(); j++){
                if (word1.charAt(i) == word2.charAt(j)) dp[i][j] = dp[i-1][j-1]; 
                else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1; 
            }
        }
        return dp[word1.length()-1][word2.length()-1];
    }
}
```


## Reference

[Youtube Video](https://www.youtube.com/watch?v=Q4i_rqON2-E&t=179s)
[Code from](https://www.youtube.com/watch?v=MLBFJpDxjTA&t=610s)