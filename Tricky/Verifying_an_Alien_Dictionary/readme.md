# [LeetCode 953. Verifying an Alien Dictionary](https://leetcode-cn.com/problems/verifying-an-alien-dictionary/)

## Methods

### Method 1

* `Time Complexity`: O(n)
* `Space Complexity`: O(1), 26个单词 空间为常数
* `Intuition`:
* `Key Points`:
* `Algorithm`:

`order`用字典建立, 每个字母代表一个数字

然后遍历`words`判断是否满足情况

### Code1

* `Code Design`:

```python
class Solution:
    def isAlienSorted(self, words: List[str], order: str) -> bool:
        # 用数组也行
        letterToNumber = {}
        for i in range(len(order)):
            letterToNumber[order[i]] = i

        for i in range(len(words) - 1):
            word1 = words[i]
            word2 = words[i + 1]
            length = max(len(word1), len(word2))
            for j in range(length):
                letter1 = -1 if j >= len(word1) else letterToNumber[word1[j]]
                letter2 = -1 if j >= len(word2) else letterToNumber[word2[j]]
                if letter2 < letter1:
                    return False
                elif letter1 == letter2:
                    continue
                else:
                    break
        return True

```