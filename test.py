'''
     1
  /  |  \
2    3    4
 \  / \
  5    6
'''

# class Node:
#     self.topological = {0: [5,3,4], 1: [2], 3:[1]} # key 入度(依赖)数量, value: []

class Solution:
    def findSubarray(self, topological):
        # ans = []
        # curLevel = 0
        # finished = {}
        # while len(topological) > 0:
        #     if curLevel in topological:
        #         arr = topological[curLevel]
        #         for i in range(len(arr)):
        #             if curLevel not in topological:
        #                 return False
        #             ans.append(arr[i])
        #         del topological[curLevel]
        #     curLevel += 1
        # return ans

solution = Solution()
print(solution.findSubarray({0: [5,6,4], 1: [2], 2: [3], 3:[1, ]}))
