# [LeetCode ]()

## Methods

### Method 1

* `Time Complexity`:
* `Intuition`:
* `Key Points`:
* `Algorithm`:

分四种情况:

负数为奇数个: 去掉绝对值最小的负数

负数为偶数个:

  1. 如果全为负数, 就去掉绝对值最大的负数
  2. 如果有正数存在, 就去掉最小的非负数

### Code

* `Code Design`:

```java
public static int findRemovedIndex(int[] array){
    // 1.统计负元素的个数
    int negativeCount = 0;
    for(int i=0; i<array.length; i++){
        if(array[i] < 0){
            negativeCount ++;
        }
    }
    // 2.根据不同情况，选择要删除的元素
    int tempIndex = 0;
    if((negativeCount&1)==1){
        //情况A：负数个数是奇数
        for(int i=1; i<array.length; i++){
            if(array[i] < 0){
                if(array[tempIndex]>=0 || array[i]>array[tempIndex]){
                    tempIndex = i;
                }
            }
        }
        return tempIndex;
    } else {
        //情况B：负数个数是偶数
        if(array.length == negativeCount){
            //子情况：所有元素都是负数
            for(int i=1; i<array.length; i++){
                if(array[i] < array[tempIndex]){
                    tempIndex = i;
                }
            }
            return tempIndex;
        };
        for(int i=1; i<array.length; i++){
            if(array[i] >= 0){
                if(array[tempIndex]<0 || array[i]<array[tempIndex]){
                    tempIndex = i;
                }
            }
        }
        return tempIndex;
    }
}
```

## Reference

[csdn](https://blog.csdn.net/csdnnews/article/details/102815159)