# [LeetCode 752. Open the Lock](https://leetcode.cn/problems/open-the-lock/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

双向bfs.

### Code1

* `Code Design`:

```python
class Solution:
    # 双向bfs
    def openLock(self, deadends: List[str], target: str) -> int:
        if target == "0000":
            return 0
        self.dead = set(deadends)
        if "0000" in self.dead:
            return -1
        pwd_to_level_1 = {"0000": 0}
        pwd_to_level_2 = {target: 0}
        queue = deque(["0000"])
        queue_reverse_side = deque([target])


        while queue and queue_reverse_side:
            if len(queue) <= len(queue_reverse_side):
                r = self.update(queue, pwd_to_level_1, pwd_to_level_2)
            else:
                r = self.update(queue_reverse_side, pwd_to_level_2, pwd_to_level_1)
            if r:
                return r
        return -1

    def spin(self, start: str) -> List[str]:
        for i in range(4):
            num = int(start[i])
            for j in [1, -1]:
                yield start[:i] + str((num + j) % 10) + start[i + 1:]

    def update(self, s: deque, visited: dict, visited_2: dict) -> int:
        while s:
            cur = s.popleft()
            level = visited[cur]
            for next_pwd in self.spin(cur):
                if next_pwd not in self.dead and next_pwd not in visited:
                    if next_pwd in visited_2:
                        return visited_2[next_pwd] + level + 1
                    else:
                        s.append(next_pwd)
                        visited[next_pwd] = level + 1
```

## Reference1

