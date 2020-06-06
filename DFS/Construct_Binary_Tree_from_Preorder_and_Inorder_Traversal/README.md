https://www.youtube.com/watch?v=6Xcz08RkRHE

难点在于 向左递归，向右递归时候，rootIndex, inStart, inEnd的选择太过于复杂
![](../../Image/Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal2.png)



![](../../Image/Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal.png)


-----------------------
优化：

仔细看代码，rootIndex 在进行右侧递归时候太复杂计算，其实可以改成全局变量，每次增加1

