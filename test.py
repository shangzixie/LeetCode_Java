class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        level = []
        queue = [root]
        ans = []
        while len(queue) > 0:
            for _ in range(len(queue)):
                node = queue.pop(0)
                level.append(node.val)
                if node.left is not None:
                    queue.append(node.left)
                if node.right is not None:
                    queue.append(node.right)
            ans.append(level)
            level = []
        return ans

root = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))

solution =Solution()
a = solution.zigzagLevelOrder(root)
print(a)
