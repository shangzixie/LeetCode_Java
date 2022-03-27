'''
arr1 = [1,2,3]
                |
                i
arr2 = [3,4,5,6,7]
          |
          j

ans = [1,2]
O(n)
O(n)

O(n)
o(1)
'''

class Solution:
    def solution(self, arr1, arr2):
        ans = []
        if arr1 is None:
            return []
        if arr2 is None:
            return arr1
        # if arr1[-1] < arr2[0] or arr1[0] > arr2[-1]:
        #     return arr1

        i = 0
        j = 0 # arr2到当前j为止, arr1 i为止有多少个数跟arr2相同

        while i < len(arr1) and j < len(arr2):
            if arr1[i] <= arr2[j]:
                if arr1[i] != arr2[j]:
                    ans.append(arr1[i])
                i += 1
                continue
            j += 1

        if i >= len(arr1):
            return ans

        while i < len(arr1):
            ans.append(arr1[i])
            i += 1
        return ans

'''
arr1 [1,2,3]     [1,2,3,4]     [1,2,3]      [1,2,2,2,3]  [1]  [1]  [4,5,6]
arr2 [1,2,3,4]   [1,2,3]       [4,5,6]      [3]          [1]  [2]  [1,2,3]
ans  []          [4]           [1,2,3]      [1,2,2,2]    []   [1]  [4,5,6]
'''

a = Solution()
print(a.solution([1,2,3], [1,2,3,4]))
print(a.solution([1,2,3,4], [1,2,3]))
print(a.solution([1,2,3], [4,5,6]))
print(a.solution([1,2,2,2,3], [3]))
print(a.solution([1], [1]))
print(a.solution([1], [2]))
print(a.solution([4,5,6], [1,2,3]))