class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        if numerator % denominator == 0:
            return str(numerator // denominator)

        ans = ''
        remainderMap = {}
        if numerator < 0 or denominator < 0:
            ans += '-'
        a = abs(numerator)
        b = abs(denominator)
        # 先搞定整数部分
        ans += str(a // b)
        ans += '.'
        a %= b
        while a != 0:
            if a in remainderMap:
                index = remainderMap[a]
                ans = ans[:index] + '(' + ans[index:]
                ans += ')'
                return ans
            a *= 10
            ans += str(a // b)
            a %= b
            remainderMap[a] = len(ans)
        return ans

solution = Solution()
solution.fractionToDecimal(4, 333)