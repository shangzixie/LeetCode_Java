# interval

设两个interval为`[l1, r1]`和`[l2, r2]`，如果讨论两个interval的收尾关系, 那情况特别复杂. 但是,如果只判断两个interval有没有重叠, 那是很容易的, 这里引入三个概念: **交集, 并集以及是否相交的判断**

![152](/Image/152.png)

## interval 两大基本操作: merge 和 insert

利用并集和判断overlapping, 可以对interval进行两大基本操作: merge 和 insert. 但是这两大基本操作都需要一开始对interval的 start进行排序

基本思路:

![153](/Image/153.png)

### merge

我们先看 merge
[LeetCode 56. Merge Intervals](/Tricky/interval/Merge_Intervals/)

## insert

接着看题目 [LeetCode 57. Insert Interval](/Tricky/interval/Insert_Interval/) , 因为它给定集合intervals的区间**互不重叠**且已经**sorted**, 所以如果某个区间并不满足要求, 我们需要先sorted, 然后merge后再insert
