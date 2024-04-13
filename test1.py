class Solution:
    """
    @param s: a string
    @return: return a integer
    """
    def longestValidParentheses(self, s):
        stack = [-1]
        maxlen = 0
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                j = stack.pop()
                if s[j] ==")" or j == -1:
                    stack.append(i)
                elif s[j] == "(":
                    maxlen = max(maxlen, i - stack[-1])
        return maxlen


so = Solution()
so.longestValidParentheses("()))()")
