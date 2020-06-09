# 36. Valid Sudoku

[LeetCode 36](https://leetcode.com/problems/valid-sudoku/)


## Methods
from the following rules:

``` 
1. Each row must contain the digits 1-9 without repetition.
2. Each column must contain the digits 1-9 without repetition.
3. Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
````
```
we could get: if 
1. there are the same num in the same row
2. there are the same num in the same column
3. there are the same num in the same 3*3 sub-boxes 
they are  invalid. 
```
so we could build `9 + 9 + 9 = 27` HashSets, which correspond `9` rows and `9` columns and `9` 3*3 sub-boxes. 
everytime, check if current value `board[x][y]` appear in the `x` row, the `y` colomn and the `x/3, y/3` sub-boxes.
If contained, return `false`. 

But we could encode them into just one set as string. Same row uses `i row board[i][j]`, same column uses `col = j col board[i][j]`
same sub-boxes uses `i/3  j/3  matr board[i][j]`. 
                                                                                                                              

### Method 1


### Key Points


### Code
```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
    
        HashSet<String> set = new HashSet<>(); 
        
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.'){
                    String row = "" + i + "row" + board[i][j];
                    String col = "" + j + "col" + board[i][j];
                    String matr = "" + i/3 + j/3 + "matr" + board[i][j];
                    if (set.contains(row) || set.contains(col) || set.contains(matr)){
                        return false;
                    } 
                    set.add(row);
                    set.add(col);
                    set.add(matr);
                    
                }
            }
        }
        return true;
        
        
    }
}

```


## Reference
https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings
