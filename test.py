# root none
# root
# false
# coordinate
class Solution:
    def getCoordinate(self, arr, target):
        x = 0
        y = len(arr) - 1
        while x < len(arr[0]) and y >= 0:
            if x < 0 or y > len(arr):
                return False
            if arr[x][y] > target:
                y -= 1
            if arr[x][y] < target:
                x += 1
            if arr[x][y] == target:
                return [x, y]
        return False



solution = Solution()
result = solution.getCoordinate([[1,5,8],[4,9,12],[6,17,34]], 6)
print(result)