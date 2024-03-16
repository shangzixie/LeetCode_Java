# Binary Search Tree (BST)

![145](/Image/145.png)

中序遍历一个BST，得到的是一个不断递增的序列

## 特征

![146](/Image/146.svg.png)

## 应用

根据上图BST的性质, 一个二叉树的节点, 左子树的值都小于它, 右子树的值都大于它, 例如上图节点root值是8, 左边所有值都比他小, 右边都比8大. 所以对于[Inorder_Successor_In_BST](/DFS/Inorder_Successor_In_BST/)这道题, 可以从上往下找:

1. 从根节点开始，每到达一个节点就比较节点的值和节点p的值
2. 如果当前节点的值小于节点p的值，那么节点p的下一个节点应该在它的右子树
3. 如果当前节点等于节点p, 要找的目标一定大于p, 应该往右子树找
4. 如果当前节点的值大于节点p的值，那么当前节点有可能是p的下一个节点，此时当前节点的值比节点p的值大，但节点p的下一个节点是所有比它大的节点中值最小的一个，因此接下来前往当前节点的左子树，确定是否能找到值更小，但仍然大于节点p的值的节点

因为找后继结点是从root节点开始, 就像指针在数组中从中间某个位置开始一样, 大于p就找比p小的, 小于p就找比p大的

```javascript
/**
 * @param {TreeNode} root
 * @param {TreeNode} p
 * @return {TreeNode}
 */
var inorderSuccessor = function(root, p) {
  let cur = root;
  let result = null;
  while (cur) {
    if (cur.val > p.val) {
      result = cur; // 有可能当前值就是节点
      cur = cur.left;
    } else {
      cur = cur.right;
    }
  }
  return result;
};
```

而[Inorder_Successor_In_BST_II](/DFS/Inorder_Successor_In_BST_II/)相当于一个数组起始位置为p, 然后找比p大的那个后继节点. 但是数组中比p大的后继节点一定在p的右边, 而在bst中并不一定. 这时候我们就要分类讨论了:

声明两个定义:
后继 = "后节点"，即在中序遍历中的下一个节点， 或者是当前节点的下一个最小的节点。
前驱 = "前节点"，即在中序遍历中的上一个节点， 或者是当前节点的上一个最大的节点。

情况1:

![147](/Image/147.png)

情况2:

![148](/Image/148.png)
怎么理解情况2呢? 要找比p节点大的后继节点, 没有右子树的情况, 那就要向上找. 向上一层, 分两种情况:

![149](/Image/149.png)