# [LeetCode 208. Implement Trie (Prefix Tree)](https://leetcode.cn/problems/implement-trie-prefix-tree/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

root is null, letter begin from its son

### Code1

* `Code Design`:

```python
class Node:
    def __init__(self):
        self.isEnd = False
        self.next = [None] * 26
class Trie(object):
    def __init__(self):
        self.root = Node()
    def insert(self, word):
        """
        :type word: str
        :rtype: None
        """
        # root is null, letter begin from its son
        cur = self.root
        for l in word:
            index = ord(l) - ord('a')
            if cur.next[index] == None:
                cur.next[index] = Node()
            cur = cur.next[index]
        cur.isEnd = True

    def search(self, word):
        """
        :type word: str
        :rtype: bool
        """
        cur = self.root
        for l in word:
            index = ord(l) - ord('a')
            if cur.next[index] == None:
                return False
            cur = cur.next[index]
        return cur.isEnd

    def startsWith(self, prefix):
        """
        :type prefix: str
        :rtype: bool
        """
        cur = self.root
        for l in prefix:
            index = ord(l) - ord('a')
            if cur.next[index] == None:
                return False
            cur = cur.next[index]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
```

## Reference1

