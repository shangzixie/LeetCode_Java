# [LeetCode 149. Max Points on a Line](https://leetcode.cn/problems/max-points-on-a-line/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

这道题就是求斜率, 但是斜率相同的两条线可能是平行线, 不一定在同一条线上. 所以我们每次固定一个点, 然后通过另一个点计算斜率,存到`map`里面, 如果斜率相同, 说明在同一条线上, 然后我们再换固定的点, 同时清零`map`, 重新计算.

但是斜率可能是无限循环或者无限不循环小数. 所以不如用分数形式存储. 但是分数形式, 有个问题: 假设三个点分别为a(x1, y1), b(x2, y2), c(x3, y3), 如果a和b的斜率是`2/3`, 而a和c的斜率是`4/6`, 按道理他们应该在同一条直线上, 存在map里面的key就不同. 所以要约分.

关于约分, 这里有两种方法:

1. 直接用`Fraction`来存储斜率
2. 自己实现一个`gcd`函数

```python
最大公约数方法:
def gcd(a, b):
    return a if b == 0 else gcd(b, a % b)
```

### Code1

* `Code Design`:

```python
from fractions import Fraction

class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        if len(points) <= 2:
            return len(points)
        slope_to_count = defaultdict(int)
        ans = 0
        for i in range(len(points)):
            print(slope_to_count)
            slope_to_count = defaultdict(int)
            for j in range(i + 1, len(points)):
                x1, y1 = points[i]
                x2, y2 = points[j]
                slope = ''
                if  x1 - x2 == 0:
                    slope = 'inf'
                else:
                    slope = str(Fraction(y1 - y2, x1 - x2))
                slope_to_count[slope] += 1
                ans = max(ans, slope_to_count[slope])
        return ans + 1
```

## Reference1

[youtube](https://www.youtube.com/watch?v=kC1vLa_vPOw)