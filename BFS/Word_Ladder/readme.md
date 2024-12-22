# [LeetCode 127. Word Ladder](https://leetcode.cn/problems/word-ladder/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

以以下输入为例子:

```python
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
```

首先我们要知道 hit 能转变成哪些单词, 这里是 hot; hot又能转换成哪些词:

```test
hit -> hot -> dot -> dog -> cog
        |->   lot -> log -> cog
```

所以根据这个图, 我们用BFS解决问题. 但是有个问题, 我们如何知道一个单词能转换成哪些单词呢?

我们可以填充在两个单词之间加入通用字符方式, 例如`hot` 可以转换成 `*ot`, `h*t`, `ho*`, 而`*ot`又可以转换成`hot`, `dot`, `lot`等等.

所以我们要有一个字典`general_to_words`, 每个key是通用字符例如`*ot`, `h*t`, `ho*`, value是所有能转换成的单词. 例如 `{'*ot': ['hot', 'dot', 'lot']}`;

我们还需要一个字典`word_to_generals`, key是单词, value是该单词可以转换的通用字符, 例如`{'hot': ['*ot', 'h*t', 'ho*']}`.

所以当我们当前单词为`hot`时候, 我们可以知道它可以转换成`*ot`, `h*t`, `ho*`, 我们又知道`*ot`可以转换成`hot`, `dot`, `lot`, `h*t`可以转换成`hot`, `hit`; 所以我们可以知道`hot`可以转换成`dot`, `lot`, `hit`. 但其实上述两个字典可以合并为一个, 姑且叫`adj`吧.

因为不能回头, 所以还需要记录走过的`visited`单词. 答案求遍历到第几层bfs得到endWord, 我们还需要一个字典`word_to_level`记录遍历到当前单词时候在第几层. `visited`和`word_to_level`可合并.

可视化为图来看, 就像在每两个单词之间插入了通用字符单词:

![172](/Image/172.png)

```python

### Code1

* `Code Design`:

```python
class Solution:
    def add_word_to_adj(self, word):
        # build general to words, for examle word is hot
        # map is {'hot': [*ot, h*t, ho*]}
        for i in range(len(word)):
            general = word[:i] + '*' + word[i + 1:]
            self.adj[word].append(general)
        # build general to words
        # map is {*ot: [hot], h*t: [hot], ho*: [hot]}
        for i in range(len(word)):
            general = word[:i] + '*' + word[i + 1:]
            self.adj[general].append(word)
        """
        以上代码可以优化为:
        for i in range(len(word)):
            general = word[:i] + '*' + word[i:]
            self.adf[general].append(word)
            self.adj[word].append(general)
        """
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        q = deque([beginWord])

        # 存储各单词被初次转换时的距离，但源点处为 0，在最后调整
        word_to_level = {beginWord: 0}
        # 邻接表
        self.adj = defaultdict(list)

        # 填充无向图的邻接表
        for word in wordList:
            self.add_word_to_adj(word)
        # don't forget the beginword
        self.add_word_to_adj(beginWord)

        # BFS
        while q:
            word = q.popleft()
            for nextWord in self.adj[word]:
                if nextWord in word_to_level:
                    continue
                word_to_level[nextWord] = word_to_level[word] + 1
                q.append(nextWord)
                if nextWord == endWord:
                    return word_to_level[nextWord] // 2 + 1  # 因为我们两个单词插入了新的通配节点, 所以这里要除以2

        return 0


```

## Reference1

----------------------
