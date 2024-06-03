"""
typedef struct {
    int startAddr;
    int endAddr;
} IoRecord;

// 注意：返回的数组必须在函数内调用malloc进行内存分配，由框架代码调用free进行内存释放。
// 返回的数组长度存在 *returnValSize 中。
static IoRecord *IoMerge(int sectorSize, const IoRecord *opArray, size_t opArraySize, size_t *returnValSize)
{
    *returnValSize = 0;
    return NULL;
}

[x1, y1] [x2, y2]
  a         b

1. 交叉
2. 不交叉

交叉: ab位置不确定
1. y1  >= x2
y2 >= x1


y1  i -> x2

intertvals = [a,b,c]
a.start
a[0]a[1]

32
[[0, 30], [10, 33], [130, 150], [151, 158], [60, 100], [130, 150], [20, 50]]
"""

class Solution:
    def mergeIntervals(self, intervals):
        if len(intervals) <= 1:
            return intervals
        ans = []
        intervals.sort(lambda x:x[0])
        ans.append(intervals[0])
        for i in range(1, len(intervals)):
            cur = intervals[i]
            last = ans[-1]
            if cur[0] > last[1]:
                ans.append(cur)
            else:
                ans[-1][1] = max(last[1], cur[1])
        return
so = Solution()

print(so.mergeIntervals([[0, 30], [10, 33], [130, 150], [151, 158], [60, 100], [130, 150], [20, 50]]))
