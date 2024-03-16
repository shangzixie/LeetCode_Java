# [LeetCode 877. Stone Game](https://leetcode.cn/problems/stone-game/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`: dfs + memo
* `Algorithm`:



### Code1

* `Code Design`:

```python
class Solution(object):
    def stoneGame(self, piles):
        """
        :type piles: List[int]
        :rtype: bool
        """
        self.mem = {}
        return self.dfs(piles, 0, len(piles) - 1, 1, 0, 0)
    """
    alice: the sum of the stones that Alice has
    bob: the sum of the stones that Bob has
    """
    def dfs(self, piles, left, right, level, alice, bob):
        if left >= right:
            bob += piles[left]
            if alice > bob:
                return True
            return False
        if (left, right) in self.mem:
            return self.mem[(left, right)]

        if level % 2 == 1:
            l = self.dfs(piles, left + 1, right, level + 1, alice + piles[left], bob)
            r = self.dfs(piles, left, right - 1, level + 1, alice + piles[right], bob)
        else:
            l = self.dfs(piles, left + 1, right, level + 1, alice, bob + piles[left])
            r = self.dfs(piles, left, right - 1, level + 1, alice, bob + piles[right])
        if l or r:
            self.mem[(left, right)] = True
        else:
            self.mem[(left, right)] = False
        return l or r
```

## Reference1

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code2

* `Code Design`:

```java


```

## Reference2
