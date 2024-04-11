class Solution(object):
    def kthSmallest(self, matrix, k):
        n = len(matrix)
        left = matrix[0][0]
        right = matrix[n - 1][n - 1]
        while left < right:
            mid = (left + right) // 2
            count = self.equalOrSmaller(mid)
            if  count < k:
                left = mid
            else:
                right = mid
        return left
