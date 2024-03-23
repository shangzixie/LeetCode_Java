
"""
Problem Statement
Imagine a file in the following fixed format:

<url><white_space><long value>

e.g.

http://api.tech.com/item/121345 9
http://api.tech.com/item/122345 350
http://api.tech.com/item/123345 25
http://api.tech.com/item/124345 231
http://api.tech.com/item/125345 111
.
.
.

Write a program that reads from 'stdin' the absolute path of a file expected
to be in this format and outputs a list of the urls associated with the 10
largest values in the right-most column. For example, given the input data
above if the question were to output the 2 largest values the output would
be:

http://api.tech.com/item/122345
http://api.tech.com/item/124345

Your solution should take into account extremely large files.

topK: 1. max heap: pop() k
sort: arr, sort
binary search
"""
import heapq # min heap, max heap
# (size, url)
class LoadBalance:
    def getTopK(self, arr, k):
        sizeToURLs = {} # size : [url, url]
        heap = []
        for str in arr:
            s = str.split(' ') # [url, size]
            if len(s) < 2:
                continue
            if s[1] in sizeToURLs:
                sizeToURLs[s[1]].append(s[0])
            else:
                sizeToURLs[s[1]] = [s[0]]
            heapq.heappush(heap, float(s[1]) * -1)
        ans = []
        for _ in range(k):
            s = heapq.heappop()
            s *= -1
            urls = sizeToURLs[s]
            for url in urls:
                if len(ans) >= k:
                    break
                ans.append(url)
        return ans


# arr = ['http://api.tech.com/item/121345 9', 'http://api.tech.com/item/122345 350']
# min heap, max heap

class LoadBalance1:
    def getTopK(self, arr, k):
        heap = []
        for str in arr:
            s = str.split(' ')  # [url, size]
            if len(s) < 2:
                continue
            # heap = [(9, url), (-350, url)]
            heapq.heappush(heap, (float(s[1]) * -1, s[0]))
        ans = []
        for _ in range(k):
            s = heapq.heappop()
            url = s[1]
            ans.append(url)
        return ans


class LoadBalance1:
    self.ans = []
    def getCurrentTopK(self, arr, k):
        ans = self.getTopK(arr, self.ans, k)
        self.ans = ans
    def getTopK(self, arr1, arr2, k):
        for str in arr1:
            s = str.split(' ')  # [url, size]
            if len(s) < 2:
                continue
            # heap = [(9, url), (-350, url)]
            heapq.heappush(self.heap, (float(s[1]) * -1, s[0]))
        for str in arr2:
            s = str.split(' ')  # [url, size]
            if len(s) < 2:
                continue
            # heap = [(9, url), (-350, url)]
            heapq.heappush(self.heap, (float(s[1]) * -1, s[0]))
        self.ans = []
        for _ in range(k):
            s = heapq.heappop(self.heap)
            url = s[1]
            ans.append(url)
        return self.ans
