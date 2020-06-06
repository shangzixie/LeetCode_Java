https://www.youtube.com/watch?v=kC1vLa_vPOw


traverse sequence is important. 

Assume there are 4 points:    
    `a, b, c, d`
     
we know 2 points confirm a line, so how to confirm the third point are in the same line??



// 首相我们需要知道一个定理： 经过同一个点，斜率相同的直线是同一条。  
// 所以固定一个点不动，然后for循环其他点，如果跟这个点斜率相同，那么这些点就在同一条直线上。
// 最后我们可以得到和该点同一直线的最大点的数量。
// 之后我们更换该固定点，计算
// 最后得到全局最大数量

![](https://i.imgur.com/pwmN6f5.png)