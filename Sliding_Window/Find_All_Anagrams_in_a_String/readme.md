# [LeetCode 438. Find All Anagrams in a String](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)

## Methods

### Method 1

* `Time Complexity`: O(m + n). m n为s1和s2长度
* `Space Complexity`: O(1)
* `Intuition`:
* `Key Points`:
* `Algorithm`:

和[permutation in string](../Permutation_in_String/readme.md)这道题的方法3一样

### Code

* `Code Design`:

```javascript
/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function(s, p) {
    if (p.length > s.length) return [];
    const ans = [];
    const n = p.length;
    // cnt的每个element表示s2目前window的字母s2[i]比s1字母多了多少个
    let cnt = new Array(26).fill(0);
    for (let i = 0; i < n; i++) {
        cnt[s[i].charCodeAt() - 'a'.charCodeAt()]++;
    }
    for (let i = 0; i < n; i++) {
        cnt[p[i].charCodeAt() - 'a'.charCodeAt()]--;
    }

    // 建立diff
    let diff = 0;
    for (let i = 0; i < 26; i++) {
        if (cnt[i] !== 0) diff++;
    }
    if (diff === 0) ans.push(0);
    // 开始滑动窗口
    // right 为 i, left 为 i - n + 1
    for (let i = n; i < s.length; i++) {
        // 更新diff
        const index1 = s[i].charCodeAt() - 'a'.charCodeAt(); // 进入window的字母
        const index2 = s[i - n].charCodeAt() - 'a'.charCodeAt(); // 离开window的字母
        // update cnt
        // 进出window字母相同
        if (s[i] === s[i-n]) {
            if (diff === 0) ans.push(i - n + 1);
            continue;
        };
        // 进来的字母
        if (cnt[index1] === 0) diff++;
        else if (cnt[index1] === -1) diff--; // 只少了一个, 进来字母后就会相同
        // 移除的字母
        if (cnt[index2] === 0) diff++
        else if (cnt[index2] === 1) diff--;
        cnt[index1]++;
        cnt[index2]--;
        // 判断diff
        if (diff === 0) ans.push(i - n + 1);
    }
    return ans;
};
```

----------------------

### Method 2

* `Time Complexity`: O(n + m)
* `Space Complexity`: O(1)
* `Intuition`:
* `Key Points`:
* `Algorithm`:

和[permutation in string](../Permutation_in_String/readme.md)这道题的方法5一样

### Code

* `Code Design`:

```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if(n < m) return res;

        int[] pCnt = new int[26];
        int[] sCnt = new int[26];

        for(int i = 0; i < m; i++){
            pCnt[p.charAt(i) - 'a'] ++;
        }

        int left = 0;
        for(int right = 0; right < n; right++){
            int curRight = s.charAt(right) - 'a';
            sCnt[curRight]++;
            while(sCnt[curRight] > pCnt[curRight]){
                int curLeft = s.charAt(left) - 'a';
                sCnt[curLeft]--;
                left++;
            }
            if(right - left + 1 == m){
                res.add(left);
            }
        }
        return res;
    }
}
```

## Reference

[leetcode ans](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/438-zhao-dao-zi-fu-chuan-zhong-suo-you-z-nx6b/)