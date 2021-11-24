# [LeetCode 684. Redundant Connection](https://leetcode-cn.com/problems/redundant-connection/)

## Methods

### Method 1

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`: 先看[Union Find](../Union_Find/readme.md)
* `Key Points`: input is array, need use Union Find Algorithm to transfer it to a graph
* `Algorithm`:

初始化, 因为节点的值是从`1`开始的, 所以建立一个union find类, 该类的数组`parent`长度为节点数量的数组
每次拿到的一对edge, 代表一对连接关系. 此时我们连接他们, 建立union find图. 当然连接前, 判断是否该edge的两个节点已经在一个`连通分量`内, 如果
在, 说明再连接他们一定形成环, 直接返回答案

### Code1

* `Code Design`:

```JavaScript
var findRedundantConnection = function(edges) {
    const u = new UnionFind(edges.length + 1)
    for (let i = 0; i < edges.length; i++) {
        const rootX = u.find(edges[i][0]), rootY = u.find(edges[i][1])
        if (rootX === rootY) return edges[i]
        else u.union(rootX, rootY)
    }
};
class UnionFind { // 并查集类
    constructor (n) {
        this.parents = new Uint16Array(n)
        while (n--) this.parents[n] = n
    }
    union (rootX, rootY) {
       this.parents[rootX] = rootY
    }
    find (x) {
        while (x !== this.parents[x]) x = this.parents[x]
        return x
    }
}

```

## Reference1

----------------------

### Method 2

* `Time Complexity`:
* `Space Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

### Code2

* `Code Design`:

```java


```

## Reference2
