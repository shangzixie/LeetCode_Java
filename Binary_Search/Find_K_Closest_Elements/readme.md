# [LeetCode 658. Find K Closest Elements](https://leetcode.cn/problems/find-k-closest-elements/description/)

## Methods

### Method 1

* `Time Complexity`: O(logn + k)
* `Space Complexity`:
* `Intuition`: sorted arr, using binary search
* `Key Points`:
* `Algorithm`:

### Code1

* `Code Design`:

```go

func findClosestElements(arr []int, k int, x int) []int {
    if k >= len(arr) {
        return arr
    }

    left := 0
    right := len(arr) - 1
    // find the closest two numbers
    for left + 1 < right {
        mid := (left + right) / 2
        if arr[mid] < x {
            left = mid
        } else {
            right = mid
        }
    }
    // not including p and q
    // define (p, q)
    p := left
    q := right
    for ;k > 0; k-- {
        if p < 0 {
            q++
        } else if q > len(arr) - 1 {
            p--
        } else if x - arr[p] > arr[q] - x {
            q++
        } else if x - arr[p] <= arr[q] - x {
            p--
        }
    }
    return arr[p + 1 : q]
}

```

## Reference1

[leetcode ans](https://leetcode.cn/problems/find-k-closest-elements/solutions/1771732/zhao-dao-k-ge-zui-jie-jin-de-yuan-su-by-ekwtd/)