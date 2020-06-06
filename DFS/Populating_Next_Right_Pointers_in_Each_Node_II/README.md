定义三个指针now, nextLevelHead,nextLevelCur。初始状态now=root; nextLevelHead = nextLevelCur = NULL 

Now是用来指向正在遍历的当前层的节点，nextLevelHead为下一层的头节点, nextLevelCur为下一层游走建立next连接的节点。 每次now遍历当前层节点，但是真正建立next连接的是nextLevelCur所在的下一层的节点。

什么时候nextLevelHead和nextLevelCur是空？ 只有当now遍历完当前节点转向下一层节点时候， now的下下层节点情况未知，此时nextLevelHead和nextLevelCur为空

当now==NULL时，说明当前层已经遍历完毕，然后怎么办呢?精彩的地方来了!就让now指向head即可，因为head就是下一层的头指针.然后将head和tail清空（指向NULL）,就重复了上面一段的操作.


![](https://i.imgur.com/g3X0EnP.png)

![](https://i.imgur.com/2vHt0rs.png)

