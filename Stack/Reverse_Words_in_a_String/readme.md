# [151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/)

## Methods

### Method 1

* `Time Complexity`: `O(n)`
* `Intuition`: `stack`
* `Key Points`:
* `Algorithm`:

### Code

* `Code Design`:

```javascript
/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    const wordList = [];
    let word = '';
    let result = '';

    for (let i = 0; i < s.length; i++) {
        if (s[i] === ' '){
            // 防止一开始就是空格
            if (word.length > 0) {
                wordList.unshift(word);
                word = '';
            }
        } else {
            word += s[i];
        }
    }

    if (word.length > 0) wordList.unshift(word);

    return wordList.join(' ');
};

```

### Method 2

* `Time Complexity`: `O(n)`
* `Intuition`: reverse whole string, then reverse every words
* `Key Points`:
* `Algorithm`:

### Code

* `Code Design`:

```javascript
/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    // reverse whole words
    const newS = s.split('').reverse().join('');
    // reverse every words
    let ans = '';
    let word = '';
    for (let i = 0; i < newS.length; i++) {
        if (newS[i] === ' ') {
            if (word.length > 0) {
                ans += ' ' + word.split('').reverse().join('');
                word = '';
            }
        } else {
            word += newS[i];
        }
    }
    if (word.length > 0) ans += ' ' + word.split('').reverse().join('');

    // 去掉开头空格
    return ans.slice(1);
};
```

## Reference
