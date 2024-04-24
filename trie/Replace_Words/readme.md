# [LeetCode 648. Replace Words](https://leetcode.cn/problems/replace-words/description/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

not use template, re-write the search function for the trie

### Code1

* `Code Design`:

```go
type Trie struct {
    children [26]*Trie
    isEnd    bool
}

func NewTrie() *Trie {
    return &Trie{}
}

func (t *Trie) Insert(word string) {
    cur := t
    for _, ch := range word {
        index := ch - 'a'
        if cur.children[index] == nil {
            cur.children[index] = &Trie{}
        }
        cur = cur.children[index]
    }
    cur.isEnd = true
}

func replaceWords(dictionary []string, sentence string) string {
    trie := NewTrie()
    for _, word := range dictionary {
        trie.Insert(word)
    }
    words := strings.Split(sentence, " ")
    for i, word := range words { // [the, cattle, was...]
        cur := trie
        for j, letter := range word { // [c, a, t, t, l, e]
            index := letter - 'a'
            fmt.Printf("%c\n", letter)
            if cur.children[index] == nil {
                break
            }
            if cur.children[index].isEnd == true {
                words[i] = word[:j + 1]
                break
            } else {
                cur = cur.children[index]
            }
        }
    }
    return strings.Join(words, " ")
}


```

## Reference1

