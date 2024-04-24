# [LeetCode 208. Implement Trie (Prefix Tree)](https://leetcode.cn/problems/implement-trie-prefix-tree/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

root is null, letter begin from its son;
isEnd is at current node

### Code1

* `Code Design`:

```go
type Trie struct {
    children    [26]*Trie
    isEnd       bool
}

func Constructor() Trie {
    return Trie{}
}

func (this *Trie) Insert(word string)  {
    cur := this
    for _, letter := range word {
        index := letter - 'a'
        if cur.children[index] == nil {
            cur.children[index] = &Trie{}
        }
        cur = cur.children[index]
    }
    cur.isEnd = true
}

func (this *Trie) Search(word string) bool {
    cur := this
    for _, ch := range word {
        index := ch - 'a'
        if cur.children[index] == nil {
            return false
        }
        cur = cur.children[index]
    }
    return cur.isEnd
}

func (this *Trie) StartsWith(prefix string) bool {
    cur := this
    for _, ch := range prefix {
        index := ch - 'a'
        if cur.children[index] == nil {
            return false
        }
        cur = cur.children[index]
    }
    return true
}


/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
```

## Reference1

