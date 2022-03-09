# heap

## heap定义

* Heap is the name of data structure. In java, to implement heap, they use a function named PriorityQueue
* In python, to implement heap, they use a function named heapq
* heap has two classes：minheap and maxheap; minheap: the son is must greater than parent but the two son cannot compare; maxheap: the son is lowest than parent

## heap properties

* value: all left son and right son couldn't compare with value, it is not certain which one is bigger; min heap: parent is smaller than son; max heap: parent is bigger than son
* 结构特性：从上到下 从左到右 依次增加节点. 用英文说, it is a complete tree

## basic operation

### push()

先插入到最底层且最左边的空位, 然后不停和parent比较大小, 上下调换
![123](../Image/123.png)

### pop()

![124](../Image/124.png)

### delete()

![125](../Image/125.png)

when pop(), adjust must be from current position to down
but delete(), adjust node maybe from current to up or down

## heapify

![126](../Image/126.png)