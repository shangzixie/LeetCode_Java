# [LeetCode 109. Convert Sorted List to Binary Search Tree](https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

快慢指针这里有个技巧, 每次要取慢指针的前一个节点, 并把它断开

### Code1

* `Code Design`:

```python

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def sortedListToBST(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[TreeNode]
        """
        return self.dfs(head)
    def dfs(self, head):
        if head is None:
            return None
        if head.next is None:
            return TreeNode(head.val)

        mid = self.getMid(head)
        root = TreeNode(mid.val)
        left = self.dfs(head)
        right = self.dfs(mid.next)
        root.left = left
        root.right = right
        return root
    def getMid(self, head):
        slow, fast = head, head
        slowPrev = None
        while fast and fast.next:
            slowPrev = slow             # <--- key point
            slow = slow.next
            fast = fast.next.next
        slowPrev.next = None
        return slow
```

## Reference1

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code2

* `Code Design`:

```python
class Solution(object):
    def sortedListToBST(self, head):
        """
        :type head: Optional[ListNode]
        :rtype: Optional[TreeNode]
        """
        return self.dfs(head, None)
    def dfs(self, left, right):
        if left == right:
            return None
        mid = self.getMedian(left, right)
        root = TreeNode(mid.val)
        root.left = self.dfs(left, mid)
        root.right = self.dfs(mid.next, right)
        return root

    def getMedian(self, left, right):
        fast = slow = left
        while fast.next != right and fast.next.next != right:
            fast = fast.next.next
            slow = slow.next
        return slow


```

## Reference2
