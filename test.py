# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pruneTree(self, gas: List, cost: List) -> None:
        profit = 0

        for i in range(len(gas)):
            for j in range(i + 1, len(gas) + i):
                index = j % len(gas)
                profit += profit + gas[index] - cost[index]
                if profit < 0:
                    profix = 0
                    break
