# [LeetCode 735. Asteroid Collision](https://leetcode-cn.com/problems/asteroid-collision/)

## Methods

### Method 1

* `Time Complexity`: O(n)
* `Space Complexity`: O(n)
* `Intuition`:
* `Key Points`:
* `Algorithm`:

碰撞只有一种情况, 当前数`cur`为负数时候, 然后`cur`前面的数为正数时候, 此时`cur`向左, 前面的某个数向右

### Code1

* `Code Design`:

```python
class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []
        for num in asteroids:
            while len(stack) > 0 and stack[-1] > 0 > num:
                if -num > stack[-1]:
                    stack.pop()
                    continue
                elif -num == stack[-1]:
                    stack.pop()
                    break
                else:
                    break
            else:
                stack.append(num)

        return stack

```

## Reference1

[leetcode ans](https://leetcode-cn.com/problems/asteroid-collision/solution/xing-xing-peng-zhuang-by-leetcode/)