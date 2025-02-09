# [LeetCode 1953. Maximum Number of Weeks for Which You Can Work](https://leetcode.cn/problems/maximum-number-of-weeks-for-which-you-can-work/description/?envType=company&envId=amazon&favoriteSlug=amazon-thirty-days)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

这道题首先想到的是heap模拟, 每次pop出来最大的两个数, 然后减一, 然后再push进去, 但是这样的时间复杂度是O(nlogn), 会超时, 因为观察到该题数据量非常庞大:

```plaintext
1 <= n <= 105
1 <= milestones[i] <= 109
```

这道题就是将不同的任务尽量分隔开, 在两个相同任务间, 插入不同的任务. 如果所有项目都能完成, 那最后的答案一定是所有任务的和. 例如例1: `[1,2,3]`, 可以排任务, 每个任务用index表示, 我们先排最多任务的任务2`[2,2,2]`,
然后再任务2中插入别的任务, 例如任务1: `[2,1,2,1,2]`, 再往后插入任务3: `[2,1,2,1,2,0]`

但是例2:`[5,2,1]`是完不成所有任务的. 因为我们先排任务0: `[0,0,0,0,0]`, 再差任务1: `[0,1,0,1,0,0,0]`,再插任务2: `[0,1,0,1,0,2,0,0]`, 我们发现总共只能完成6个任务.

所以什么时候能完成所有任务呢? 假设所有任务从多到少排列为 `a,b,c,....`, 那么先把最多任务的`a`排列,`[a, a, a...a]`, 然后在a任务之间插入b,c,d..任务. 所以当`a == b + c + d + ...` 或 `a - 1 == b + c + d + ...` 或`a + 1 == b + c + d + ...`时, 可以完成所有任务, 这时候
`ans = a + b + c + d + ...`.

也就是说

```
if a == b + c + d + ... or a = b + c + d + ... + 1 or a = b + c + d + ... - 1:
    ans = a + b + c + d + ...
```

那么剩下就是讨论`a < b + c + d + ... - 1`和 `a > b + c + d + ... + 1`的情况:

`a > b + c + d + ... + 1`的情况好理解: 先插入a任务, 然后插入b,c,d...任务, 最后一个任务就得是a, 所以插入方法就是先排列a:`[a, a, a ...]`然后插入剩下所有任务, `ans = (b + c + ...) * 2 + 1` 最后加1是最后一个放a任务.

`a < b + c + d + ... -1`的情况比较复杂, 不能首先放a任务. 我们应该交叉放其他任务: `[b, c, d..., b, c, d...]`, 然后再放a任务, 具体请参考reference1.

### Code1

* `Code Design`:

```python
class Solution:
    def numberOfWeeks(self, milestones: List[int]):
        # 耗时最长工作所需周数
        longest = max(milestones)
        # 其余工作共计所需周数
        rest = sum(milestones) - longest
        if longest > rest + 1:
            # 此时无法完成所耗时最长的工作
            return rest * 2 + 1
        else:
            # 此时可以完成所有工作
            return longest + rest

作者：力扣官方题解
链接：https://leetcode.cn/problems/maximum-number-of-weeks-for-which-you-can-work/solutions/908442/ni-ke-yi-gong-zuo-de-zui-da-zhou-shu-by-rbidw/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

## Reference1

[leetcode answer](https://leetcode.cn/problems/maximum-number-of-weeks-for-which-you-can-work/solutions/909585/ezi-zai-fei-hua-e-bi-jiao-hao-li-jie-de-8in32/?envType=company&envId=amazon&favoriteSlug=amazon-thirty-days)
