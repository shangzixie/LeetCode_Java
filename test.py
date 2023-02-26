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

import copy
class Solution:
   """
   @param: nums: A list of integers.
   @return: A list of permutations.
   """
    def permute(self, nums):
        renderNum = nums
        for num in nums:
            renderNum.append(-1 * num)
        self.results = []
        self.dfs([], renderNum)

        self.res = []
        for nums in self.results:
            a = nums[0]
            b = nums[1]
            c = nums[2]
            if a + b + c == 24:
                xxx
        return self.res

   def dfs(self, path, renderNum):
      if len(path) == len(renderNum):
         self.results.append(copy.deepcopy(path))
         return


      for num in renderNum:
         if num not in path:
            path.append(num)
            self.dfs(path, renderNum)
            path.pop()
