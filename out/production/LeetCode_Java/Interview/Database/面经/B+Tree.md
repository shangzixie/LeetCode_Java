https://www.youtube.com/watch?v=aZjYr87r1b8&t=49s

A disk could have many blocks.  Blocks = (track, vector)  512 byte  0--511 (offset)

first level index, high level index

BST--- m-ways search tree -怎么能自动管理表格，增改--B tree(MV trees with some rules)

## 1. B tree
* `1.`if a B tree is M degree. You can create a new node only if the node has M/2 children 
* `2.`root can have min 2 children 
* `3.`all leaf at same level 
* `4.`creation process is bottom - up
    
## 2. B Tree in Database
* every node's key has pointer to database record 
![](../../Image/BTree.png) 

## 3. B+ Tree 
1. difference with b tree: 
* every node's key has copy in the leaf node 
* just leaf node has record pointer     
* leaf node form a linked list 
![](../../Image/B+Tree.png)