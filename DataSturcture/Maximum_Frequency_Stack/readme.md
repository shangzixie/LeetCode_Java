# 895. Maximum Frequency Stack

[LeetCode 895](https://leetcode.com/problems/maximum-frequency-stack/)

## Methods

### Method 1

using two map, one is to store the frequency of each element, the other is to store the elements with the same frequency.
there are two key points:

1. we use a variable `maxFreq` to store the maximum frequency of the elements, so we can pop the elements with the maximum frequency.
2. no need to update the `frequency: [numbers]` map when push a new number. The clever part is that if a number 'x' appears five times, then in each of the five stacks, namely frequency 1, frequency 2, ..., frequency 5, there is 'x'.

### Key Points

### Code

```golang
type FreqStack struct {
    freq    map[int]int
    group   map[int][]int
    maxFreq int
}

func Constructor() FreqStack {
    return FreqStack{map[int]int{}, map[int][]int{}, 0}
}

func (f *FreqStack) Push(val int) {
    f.freq[val]++
    f.group[f.freq[val]] = append(f.group[f.freq[val]], val)
    f.maxFreq = max(f.maxFreq, f.freq[val])
}

func (f *FreqStack) Pop() int {
    val := f.group[f.maxFreq][len(f.group[f.maxFreq])-1]
    f.group[f.maxFreq] = f.group[f.maxFreq][:len(f.group[f.maxFreq])-1]
    f.freq[val]--
    if len(f.group[f.maxFreq]) == 0 {
        f.maxFreq--
    }
    return val
}

func max(a, b int) int {
    if b > a {
        return b
    }
    return a
}
```

## Reference

[leetcode] (https://leetcode.cn/problems/maximum-frequency-stack/solutions/1997251/zui-da-pin-lu-zhan-by-leetcode-solution-moay/)