'''
maxHeap
arr
'''
class Solution:
    self.heap = []
    self.arr = []
    def getKth(self, k) -> None:
        num = None
        while k > 0:
            num = heapq.heappop(self.heap)
            self.arr.append(num)
            k-= 1
        for i in range(len(arr)):
            heapq.heappush(self.heap, arr[i])
            self.arr = []
            return num