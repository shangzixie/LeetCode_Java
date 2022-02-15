class Solution:
    def maxProduct(self, words):
        numbers = self.parseWordsToNumbers(words)
        maxProduct = 0
        for i in range(len(numbers)):
            for j in range(i + 1, len(numbers)):
                if numbers[i] | numbers[j] != 0:
                    continue
                maxProduct = max(len(words[i]) * len(words[j]), maxProduct)
        return maxProduct

    def parseWordsToNumbers(self, words):
        numbers = []
        for i in range(len(words)):
            word = words[i]
            curNumber = 0
            for j in range(len(word)):
                index = ord(word[j]) - ord('a')
                curNumber |= (1 << index)

            numbers.append(curNumber)
        return numbers

solution = Solution()
solution.maxProduct(["abcw","baz","foo","bar","xtfn","abcdef"])