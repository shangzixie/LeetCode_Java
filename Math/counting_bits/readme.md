# [LeetCode 338. Counting Bits](https://leetcode-cn.com/problems/counting-bits/)

## Methods

### Method 1

* `Time Complexity`: o(n)
* `Intuition`: dp
* `Key Points`:
* `Algorithm`:

对于所有的数字，只有两类：

奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。

```java
举例：
  0 = 0       1 = 1
  2 = 10      3 = 11
```

偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。

```java
举例：
  2 = 10       4 = 100       8 = 1000
  3 = 11       6 = 110       12 = 1100
```

另外，0 的 1 个数为 0，于是就可以根据奇偶性开始遍历计算了。

### Code

* `Code Design`:

```javascript
/**
 * @param {number} n
 * @return {number[]}
 */
var countBits = function(n) {
    if (n === 0) return [0];

    const ans = [0];
    for (let i = 1; i <= n; i++) {
        if (i % 2 === 1) {
            ans[i] = ans[i - 1] + 1;
        } else {
            ans[i] = ans[i / 2];
        }
    }

    return ans;
};

```

## Reference

[link](https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/)
