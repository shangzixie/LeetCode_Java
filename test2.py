"""
Input: words1 = ["amazon","apple","facebook","google","leetcode"], 
words2 = ["ec","oc","ceo"] 
{
    ec
    ceoo
    oc
{
    c: 
    o
    e
}
map = {}
map = [1, 3, ...] * 26

Output: ["facebook","leetcode"]
"""

# for word1:
#     map = {a: 2, m: 1..}
#     for word2:
#         "e"
#         word1.contains(word2)
        

#     [{e:1, c:1}, {o1,c1}..]
#     # {e: }

# maps = []
# for word in words2:
#     letterToCount = {}
#     for letter in word:
#         if letter not in letterToCount:
#             letterToCount[letter] = 1
#         else:
#             letterToCount[letter] += 1
#     maps.append(letterToCount)

# flag = False
# for word in words1: # facebook
#     for letterToCount in maps: # {e:1, c:1}
#         for letter in word:
#             if letter in letterToCount:
#                 letterToCount[letter] -= 1
#             else:
#                 flag = True
#                 break

words = ['ac', 'aoc', 'bc']
w = set(words)
print(w)
        