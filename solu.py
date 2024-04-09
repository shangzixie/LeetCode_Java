
"""
input: 1,3,5,7,9;2,4,6,8;-2,-1

[13579]
[2468]
[-2 -1]
"""

# f(n) = f(n-1) + f(n - 2)
import heapq


class Node:
    def __init__(self, val = 0, next = None):
        self.next = next
        self.val = val
class Solution:
    def solution(self, strs): # from 1
        # minheap: [1, 2, -2]
        heads = []
        linkedlist = strs.split(";") # ["1,3,5" , "2,4,6,8", "-2, -1"]
        for subStr in linkedlist:
            nums = subStr.split(",")
            dummy = Node()
            p = dummy
            for num in nums:
                p.next = Node(int(num))
                p = p.next
            heads.append(dummy.next)

        minHeap = []
        # heapify: O(m)
        # maintain heap, heap size is m -> logm
        for node in heads:
            heapq.heappush(minHeap, (node.val, node))
        # minHeap =  [1, 2, -2]
        dummy = Node()
        p = dummy

        # O(n) * O(logm)
        while minHeap:
            _, node = heapq.heappop(minHeap)
            p.next = node
            p = p.next
            if node.next:
                heapq.heappush(minHeap, (node.next.val, node.next))

        p = dummy.next
        while p:
            print(p.val)
            p = p.next
        return dummy.next


solu = Solution()
solu.solution("1,3,5,7,9;-2,-1;2,4,6,8")
