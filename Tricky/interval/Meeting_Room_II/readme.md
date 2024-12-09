# [LeetCode 253. Meeting Rooms II](https://leetcode.cn/problems/meeting-rooms-ii/description/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=MEDIUM)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

reference里面的视频讲的最详细.

文字版如下:

每次新的时间interval过来, 都需要遍历之前已经占用的meeting room的时间, 新的会议开始时间不能早于存在的所有会议结束的时间. 一般哪个会议室结束的早, 用哪个会议室. 这里就会用到min_heap

### Code1

* `Code Design`:

```python
 class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        # 如果没有要安排的会议，则不需要分配房间。
        if not intervals:
            return 0

        # 堆初始化
        free_rooms = []
        # 按会议开始时间的升序对会议进行排序。
        intervals.sort(key= lambda x: x[0])
        # 添加第一次会议。我们得给第一次会议腾出一间新房间。
        heapq.heappush(free_rooms, intervals[0][1])

        # 对于所有剩余的会议室
        for i in intervals[1:]:
            # 如果最早应该腾出的房间是空闲的，则将该房间分配给本次会议。
            if free_rooms[0] <= i[0]:
                heapq.heappop(free_rooms)

            # 如果要分配一个新房间，那么我们也要添加到堆中，
            # 如果分配了一个旧房间，那么我们还必须添加到具有更新的结束时间的堆中。
            heapq.heappush(free_rooms, i[1])

        # 堆的大小告诉我们所有会议所需的最小房间。
        return len(free_rooms)

```

## Reference1

[youtube](https://www.youtube.com/watch?v=4MEkBvqE_2Q&t=510s)
