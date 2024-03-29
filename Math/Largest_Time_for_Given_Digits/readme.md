# [LeetCode 949. Largest Time for Given Digits](https://leetcode-cn.com/problems/largest-time-for-given-digits/)

## Methods

### Method 1

* `Time Complexity`:O(1)
* `Intuition`: 直接组合 比较
* `Key Points`:
* `Algorithm`:

### Code

* `Code Design`:

```java
    /**
     * 4个数字全排列总共有24种可能，判断每一种可能是否能组成合法时间值，如果能，再和当前保存的最大值进行比较；
     * 最大值是一个int值，用来表示分钟数；
     */
    public String largestTimeFromDigits(int[] array) {
        int largestTime = -1;

        // 暴力枚举出每种可能
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i == j || i == k || j == k) continue; // avoid duplicate among i, j & k.
                      // 0,1,2,3 总和为6，故剩下的index为6-
                      int l = 6 - i - j - k;

                      int result = largestTimeHelper(array[i], array[j], array[k], array[l]);

                      largestTime = Math.max(result, largestTime);
                }
            }
        }
        if (largestTime==-1){
            return "";
        }
        return String.format("%2d:%2d",largestTime/60,largestTime%60);
    }

    /**
     * 判断输入的四个数字按照输入顺序组成的时间是否合法，如果合法，返回分钟数；
     */
    public int largestTimeHelper(int a, int b, int c, int d) {
        int hours = a * 10 + b;
        int min = c * 10 + d;

        if (hours < 24 && min < 60) {
            // 返回分钟数
            return hours * 60 + min;
        }
        return -1;
    }
```

```javascript
/**
 * @param {number[]} arr
 * @return {string}
 */
var largestTimeFromDigits = function(arr) {
    let largestTime = -1;
    for (let i = 0; i< 4; i++) {
        for (let j = 0; j < 4; j++) {
            for (let k = 0; k < 4; k++) {
                if (i == k || j == k || i == j ) continue;
                let l = 6 - i - j - k;
                let result = helper(arr[i], arr[j], arr[k], arr[l]);
                largestTime = Math.max(result, largestTime);
            }
        }
    }
    if (largestTime === -1) return '';
    let hour = Math.floor(largestTime / 60);
    let minute = largestTime % 60;

    if (hour === 0) hour = '00';
    if (hour > 0 && hour < 10) hour = '0' + hour;
    if (minute === 0) minute = '00';
    if (minute > 0 && minute < 10) minites = '0' + minute;
    return '' + hour + ':'+ minute;
};

var helper = function(a, b, c, d) {
    let hour = a * 10 + b;
    let minute = c * 10 + d;
    if (hour < 24 && minute < 59) {
        return hour * 60 + minute;
    }
    return -1;
}
```

## Reference
