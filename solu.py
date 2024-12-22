class Solution:
    # 双向bfs
    def openLock(self, deadends: List[str], target: str) -> int:
        if target == "0000":
            return 0
        dead = set(deadends)
        if "0000" in dead:
            return -1
        d = {"0000": 0}
        ed = {target: 0}
        q = deque(["0000"])
        eq = deque([target])

        def spin(start: str) -> List[str]:
            for i in range(4):
                num = int(start[i])
                for j in [1, -1]:
                    yield start[:i] + str((num + j) % 10) + start[i + 1:]

        def update(s: deque, visited: dict, u: dict) -> int:
            while s:
                cur = s.popleft()
                tim = t[cur]
                for st in spin(cur):
                    if st not in dead and st not in visited:
                        if st in u:
                            return u[st] + tim + 1
                        else:
                            s.append(st)
                            visited[st] = tim + 1

        while q and eq:
            if len(q) <= len(eq):
                r = update(q, d, ed)
            else:
                r = update(eq, ed, d)
            if r:
                return r
        return -1