'''
     1
  /  |  \
2    3    4
 \  / \

  5    6
'''

# class Node:
#     self.topological = {0: [5,3,4], 1: [2], 3:[1]} # key 入度(依赖)数量, value: []


from sys import maxunicode


class Solution:
    def applicationPairs(self, deviceCapacity, foregroundAppList, backgroundAppList):
        foregroundAppList.sort(key = lambda x:x[1])
        backgroundAppList.sort(key = lambda x:x[1])
        print(foregroundAppList)
        print(backgroundAppList)
        # tow pointer
        i = len(foregroundAppList) - 1
        j = 0
        maxUsedMemory = 0
        ans = []
        while i >= 0 and j < len(backgroundAppList):
            curMemory = foregroundAppList[i][1] + backgroundAppList[j][1]
            if curMemory > deviceCapacity:
                i -= 1
            else:
                if curMemory > maxUsedMemory:
                    maxUsedMemory = curMemory
                    ans = [[foregroundAppList[i][0], backgroundAppList[j][0]]]
                elif curMemory == maxUsedMemory:
                    ans.append([foregroundAppList[i][0], backgroundAppList[j][0]])
                    while i > 0 and foregroundAppList[i][1] == foregroundAppList[i-1][1]:
                        i -= 1
                        ans.append([foregroundAppList[i][0], backgroundAppList[j][0]])
                    while j < len(backgroundAppList) - 1 and backgroundAppList[j][1] == backgroundAppList[j+1][1]:
                        j += 1
                        ans.append([foregroundAppList[i][0], backgroundAppList[j][0]])
                j += 1
        ans.sort(key = lambda x:x[0])
        return ans

    # def applicationPairs1(self, deviceCapacity, foregroundAppList, backgroundAppList):
    #     ans = []
    #     maxUsedMemoty = 0
    #     for i in range(len(foregroundAppList)):
    #         for j in range(len(backgroundAppList)):
    #             curMem = foregroundAppList[i][1] + backgroundAppList[j][1]
    #             if curMem > deviceCapacity:
    #                 continue
    #             if curMem < maxUsedMemoty:
    #                 continue
    #             if curMem == maxUsedMemoty:
    #                 ans.append([foregroundAppList[i][0], backgroundAppList[j][0]])
    #             elif curMem > maxUsedMemoty:
    #                 maxUsedMemoty = curMem
    #                 ans = [[foregroundAppList[i][0], backgroundAppList[j][0]]]
    #     ans.sort(key = lambda x:x[0])
    #     return ans

solution = Solution()
# print(solution.applicationPairs(10, [[1,3],[2,5],[3,7],[4,10]], [[1,2],[2,3],[3,4],[4,5]]))
# print(solution.applicationPairs(7, [[1,2],[2,4],[3,6]], [[1,2]]))
# print(solution.applicationPairs(19, [[1,10],[3,12],[4,14],[2,13]], [[1,7],[2,6],[3,10]]))
print(solution.applicationPairs(
    12,
    [[1, 2], [2, 3], [3, 6], [4, 2], [5, 4], [6, 4], [7, 7], [8, 9], [9, 1], [10, 12]],
    [[2, 6], [3, 11], [6, 3], [1, 6], [4, 11], [5, 4], [7, 7], [9, 6], [10, 8], [8, 10]])
)
