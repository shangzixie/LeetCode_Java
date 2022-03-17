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
import copy

class Solution:
    def applicationPairs(self, nums):
        nums = sorted(nums)
        self.results = []
        self.dfs(nums, 0, [])
        return self.results

    def dfs(self, nums, index, subset):
        self.results.append(copy.deepcopy(subset))
        for i in range(index, len(nums)):
            subset.append(nums[i])
            self.dfs(nums, i + 1, subset)
            subset.pop()

solution = Solution()
solution.applicationPairs([1,2,3])
