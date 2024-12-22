
from collections import deque, defaultdict


class Solution:
    def add_word_to_adj(self, word):
        # build general to words, for examle word is hot
        # map is {'hot': [*ot, h*t, ho*]}
        generals = []
        for i in range(len(word)):
            general = word[:i] + '*' + word[i:]
            generals.append(general)
        self.adj[word].append(generals)
        # build general to words
        # map is {*ot: [hot], h*t: [hot], ho*: [hot]}
        for i in range(len(word)):
            general = word[:i] + '*' + word[i:]
            self.adj[general].append(word)
        """
        以上代码可以优化为:
        generals = []
        for i in range(len(word)):
            general = word[:i] + '*' + word[i:]
            generals.append(general)
            self.adf[general].append(word)
        self.adj[word].append(generals)
        """

    def ladderLength(self, beginWord, endWord, wordList):
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
                    # 因为我们两个单词插入了新的通配节点, 所以这里要除以2
                    return word_to_level[nextWord] // 2 + 1

        return 0



solu = Solution()
solu.ladderLength("hit", "hot", ["hot", "dot", "dog", "lot", "log", "cog"])
