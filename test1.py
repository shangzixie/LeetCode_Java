class Solution(object):
    def getFactors(self, n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        nums = self.getFactors(n)
        self.ans = []

        self.dfs(nums, [], 0)
        return self.ans

    def dfs(self, nums, path, startIndex):
        if startIndex == len(nums):
            self.ans.append(copy.deepcopy(path))
            return

        for i in range(startIndex, len(nums)):
            product = 1
            for j in range(startIndex, len(nums)):
                product *= nums[j]
            path.append(product)
            self.dfs(nums, path, i + 1)
            path.pop()

    def getFactorsNums(self, n):
        ans = []
        a = n
        b = 2
        while b < n and a != 1:
            if a % b == 0:
                ans.append(b)
                a = a // b
            else:
                b += 1
        return ans


print("1234455566")
so = Solution()
so.getFactors(12)
