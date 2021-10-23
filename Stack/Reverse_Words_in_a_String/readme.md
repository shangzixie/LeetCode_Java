# [151. Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/)

## Methods

### Method 1

* `Time Complexity`: `O(1)`
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

## Reference
