# 406. Queue Reconstruction by Height

[LeetCode 406](https://leetcode.com/problems/queue-reconstruction-by-height/)


## Methods

### Method 1
* `Time Complexity`: o(n^2) 
* `Intuition`: we could insert element from highest to lowest. Due to tall person cannot be influenced by Shorty。 
* `Algorithm`: 
```
if we sort it by second number from min number to insert : 
[5, 0] [7, 0] -->
[5, 0] [7, 0][6,1][7,1] -->
[5, 0] [7, 0][5,2][6,1][7,1] -->
[5, 0] [7, 0][5,2][6,1][4,4][7,1] 
when we want to insert [7,1], if it insert between[7,0] and [6,1] , need to check the valid of [6,1]
In other words, from left to right to sort then insert, an element will infunce others valid. 


this problem, the biggest issue is when we insert an element, it will influence other exists elements
-------------------------------------
so, we could insert element from highest to lowest. Due to tall person cannot be influenced by Shorty。 

```
### Key Points


### Code
```java
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]); 
        List<int[]> ans = new ArrayList<>(); 
        
        for (int i = 0; i < people.length; i++) {
            ans.add(people[i][1], people[i]);
        }
        return ans.toArray(new int[0][0]);
    }
}

```


## Reference
[LeetCode Chineser Solution](https://leetcode-cn.com/problems/queue-reconstruction-by-height/solution/gen-ju-shen-gao-zhong-jian-dui-lie-by-leetcode/)