from collections import defaultdict, deque
import time


class BotDetector:
    def __init__(self, threshold: int, window: int):
        """
        参数:
            threshold: 在窗口内允许的最大请求次数
            window: 时间窗口大小（单位秒）
        """
        self.threshold = threshold
        self.window = window
        # 为每个IP维护一个队列存储时间戳
        self.ip_queues = defaultdict(deque)

    def add_request(self, timestamp: int, ip: str) -> bool:
        """
        添加一个新的请求，并返回该 IP 是否被认为是 bot（True 为 bot）。
        """
        dq = self.ip_queues[ip]
        dq.append(timestamp)
        # 移除队列中时间戳超出当前时间窗口的数据
        while dq and timestamp - dq[0] > self.window:
            dq.popleft()
        # 如果当前窗口内的请求数超过阈值，则认为是 bot
        if len(dq) > self.threshold:
            return True
        return False


# 示例调用
if __name__ == '__main__':
    detector = BotDetector(threshold=3, window=60)

    # 模拟一系列请求（时间戳可以是当前时间，也可以是模拟数据）
    requests = [
        (1610000000, "192.168.1.1"),
        (1610000005, "192.168.1.2"),
        (1610000010, "192.168.1.1"),
        (1610000015, "192.168.1.1"),
        (1610000020, "192.168.1.1"),  # 这一请求后 192.168.1.1 超过阈值
        (1610000025, "192.168.1.2")
    ]

    for ts, ip in requests:
        is_bot = detector.add_request(ts, ip)
        print(f"请求 {ts}, {ip} -> {'bot' if is_bot else '正常'}")
