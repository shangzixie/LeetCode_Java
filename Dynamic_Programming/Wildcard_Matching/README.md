# 44. Wildcard Matching

[LeetCode 44](https://leetcode.com/problems/wildcard-matching/)


## Methods
### Method 1


### Key Points
when `*` denotes 1 letter:`dp[i][j] = dp[i-1][j-1]; 

when `*` denotes many letter:`dp[i][j] = dp[i-1][j];

just I prove in [Regular_Expression_Matching](../Regular_Expression_Matching), it all equals to `dp[i][j] = dp[i-1][j]`

### Code
```java
class Solution {
    public boolean isMatch(String s, String p) {
        s = "#" + s; 
        p = "#" + p; 
        boolean[][] dp = new boolean[s.length()][p.length()]; 
        
    //initial conditon
        dp[0][0] = true; //when p,s are null 
        // when s is null;         
        for (int j = 1; j < p.length(); j++){
            if (p.charAt(j) == '*') dp[0][j] = dp[0][j-1]; 
            else dp[0][j] = false; 
        }
        // when p is null; 
        for (int i = 1; i < s.length(); i++){
            dp[i][0] = false; 
        }
        
    //traverse the dp
        for (int i = 1; i < s.length(); i++){
            for (int j = 1; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j)) dp[i][j] = dp[i-1][j-1]; 
                else{
                    if (Character.isLetter(p.charAt(j))) dp[i][j] = false; 
                    else if (p.charAt(j) == '?') dp[i][j] = dp[i-1][j-1]; 
                    else dp[i][j] = dp[i-1][j] || dp[i][j-1]; // "*" denotes 0 letter, or "*" means 1 or many letters
                }
            }
        }
        return dp[s.length()-1][p.length()-1]; 
    }
}

```


## Reference