class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        sortedStrToOrigin = {}
        count = [0 for _ in range(26)]

        for word in strs:
            for i in range(len(word)):
                count[ord(word[i]) - ord('a')] += 1

            for i in range(len(count)):
                if count > 0:
                    key += chr(i) + str(count[i])

            if key in sortedStrToOrigin:
                sortedStrToOrigin[key].append(word)
            else:
                sortedStrToOrigin[key] = [word]

        result = []
        for value in sortedStrToOrigin.values():
            result.append(value)

        return result