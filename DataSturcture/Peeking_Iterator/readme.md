# [LeetCode 284. Peeking Iterator](https://leetcode.com/problems/peeking-iterator/)

## Methods

### Method 1

* `Time Complexity`:
* `Intuition`: use pointer to point current's next element
* `Key Points`:
* `Algorithm`:

it give us a iterator interface, we need to use this iterator api
该题题目有一定的疑惑性, 给我们的并不是一个数组, 而是一个迭代器, 我们要利用这个迭代器的api去实现我们自己的迭代器
看样例可知:
1.初始状态迭代器的指针在第一个元素的前面,即index为-1处
2. `peek()`作用: 返回当前指针的下一个元素
2.`next()`作用: 先返回当前指针的元素,并把指针往后移动一位

根据上述理解, 例子

```JavaScript
输入
["PeekingIterator","peek","peek","next","next","hasNext"]
[[[1,2,3]],[],[],[],[],[]]

则输出为
[null,1,1,1,2,true]
```

### Code

* `Code Design`:

```javascript

/**
 * @param {Iterator} iterator
 */
var PeekingIterator = function(iterator) {
    this.iterator = iterator;
    if (this.iterator.hasNext()) {
        this.peekNum = this.iterator.next();
    } else {
        this.peekNum = null;
    }
};

/**
 * @return {number}
 */
PeekingIterator.prototype.peek = function() {
    return this.peekNum;
};

/**
 * @return {number}
 */
PeekingIterator.prototype.next = function() {
    const temp = this.peekNum;
    this.peekNum = this.iterator.hasNext() ? this.iterator.next() : -1;

    return temp;
};

/**
 * @return {boolean}
 */
PeekingIterator.prototype.hasNext = function() {
    if(this.peekNum !== -1) return true;
    return false;
};
```

## Reference

[video](https://www.youtube.com/watch?v=evNDFy6Gtg0)
