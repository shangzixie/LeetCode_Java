定义三个指针now, nextLevelHead,nextLevelCur。初始状态now=root; nextLevelHead = nextLevelCur = NULL 

Now是用来指向正在遍历的当前层的节点，nextLevelHead为下一层的头节点, nextLevelCur为下一层游走建立next连接的节点。 每次now遍历当前层节点，但是真正建立next连接的是nextLevelCur所在的下一层的节点。

什么时候nextLevelHead和nextLevelCur是空？ 只有当now遍历完当前节点转向下一层节点时候， now的下下层节点情况未知，此时nextLevelHead和nextLevelCur为空


![](https://i.imgur.com/g3X0EnP.png)

![](https://i.imgur.com/2vHt0rs.png)

