# root none
# root
# false
# coordinate
class Solution:
    def findDuplicates(self, nums):
        # use array replace of set
        # arr[i] is negative, meaning i+1 appears twice
        ans = []
        for i in range(len(nums)):
            if nums[i] < 0:
                ans.append(i + 1)
                continue
            nums[nums[i] - 1] *= -1
        return ans



solution = Solution()
result = solution.findDuplicates([4,3,2,7,8,2,3,1])
print(result)