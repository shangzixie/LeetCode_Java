class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        intervals = sorted(intervals, key=lambda x: x[0])
        ans = []
        print(intervals)
        start = intervals[0][0]
        end = intervals[0][1]
        for i in range(0, len(intervals)):
            if intervals[i][0] <= end:
                end = max(end, intervals[i][1])
            else:
                ans.append([start, end])
                start = intervals[i][0]
                end = intervals[i][1]
        ans.append([start, end])
        return ans


s = Solution()
s.merge([[1,4],[0,4]])