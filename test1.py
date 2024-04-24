class Solution:
    """
    input: [[1,3], [2,4], [4,6]]
                     i    
                           j
    output: how many 

    {point: distance}
    distance count > 2:
        ans += 1
    p: distance, point
    point: {distance:[points]}
    visited = []
    {distance: count} -> C

    """
    def getNums(self, nums):
        distanceToCount = {} # key is distance , value count
        for i in range(len(nums)):
            for j in range(len(nums)):
                if i == j:
                    continue
                distanceToCount = {}
                x1, y1 = nums[i][0], nums[i][1]
                x2, y2 = nums[j][0], nums[j][1]
                distance = (y2 - y1)^2 + (x2 - x1)^2
                if distance in distanceToCount:
                    distanceToCount[distance] += 1
                else:
                    distanceToCount[distance] = 1
            ans = 0
            for dis in distanceToCount:
                count = distanceToCount[dis]
                ans += count * (count - 1) / 2
        return ans


so = Solution()
so.longestValidParentheses("()))()")
