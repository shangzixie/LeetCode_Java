class Solution:
    def nextPermutation(self, nums):
        """
        Do not return anything, modify nums in-place instead.
        """
        curMax = nums[-1]
        for i in range(len(nums) - 2, -1, -1):
            curNum = nums[i]
            # 判断当前数num是否为目前为止最大的数
            if curNum > curMax:
                curMax = curNum
                continue
            # 如果当前数不是目前最大的数, 找到比当前数大的最小数, 其他数升序排列
            newArrIndex = i + 1
            index = len(nums) - 1 # 比当前数大的最小数的index
            minNumLargerThanCur = float('inf')
            for j in range(newArrIndex, len(nums)):
                if nums[j] > curNum and nums[j] < minNumLargerThanCur:
                    minNumLargerThanCur = nums[j]
                    index = j
            nums[index], nums[i] = nums[i], nums[index]
            nums[i+1:].sort()
            return nums
        return nums.sort()

solution = Solution()
solution.nextPermutation([1,3,2])