# [LeetCode 108. Convert Sorted Array to Binary Search Tree](https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

require convert it to a height-balanced binary search tree. the nums is sorted in ascending order, so the middle element as the root, then divided the array to two sub-array, we continue to divided the array. the base case is the array is empty or only one element. Then every time it recursion to current node, we connect the left and right child to the root.

```python
class Solution(object):
    def sortedArrayToBST(self, nums):
        """
        :type nums: List[int]
        :rtype: TreeNode
        """
        return self.dfs(nums, 0, len(nums) - 1)

    def dfs(self, nums, left, right):
        if left > right:
            return None
        if left == right:
            return TreeNode(nums[left])

        mid = (left + right) // 2
        root = TreeNode(nums[mid])
        left = self.dfs(nums, left, mid - 1)
        right = self.dfs(nums, mid + 1, right)
        root.left = left
        root.right = right
        return root
```

## Reference1

[LeetCode Solution](https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/solutions/312607/jiang-you-xu-shu-zu-zhuan-huan-wei-er-cha-sou-s-33/)