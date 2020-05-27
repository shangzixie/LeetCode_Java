

```
valueOf(): xx.valueOf 就是把什么转化成XX

1. 一个数组或字符转化为string 
               
    1. String.valueOf(int a)  
        1 -->"1"
    2. String.valueOf(boolean a)
        true --> "true"

    ...

2. 一个基本数据类型转换为另一个数据类型
    1. Integer.valueOf(char a)
        '1'--> 1
    2. String.valueOf(String a)
        "1" --> 1
    ...

```

```

对Array进行操作
    1. 转化为string
        char[] a 
        int[] b
        
        1. String.valueOf(char[] a / int[] a) 
        2. new String(char[] a / int[] a) 
    
    2. to ArrayList
        List<String> list1 = Arrays.asList(array);    

转换为Array
    1. linkedlist 或者 arraylist 转换为array
            al.toArray() 

    

    
```

```
对List进行操作

    1. 转换为数组：
    Integer a = arr.toArray(new int[0]); 

```

```
对String进行转换
    1. 转换为Char数组
        str.toCharArray() 
    
    2. 转换为固定的char
        str.charAt(index) 

    3. 转换为整数，char等
        Integer.valueOf(str.charAt()) 


转换为String
    1. 转化为string           
       1. String.valueOf(char[] a / int[] a) 
       2. new String(char[] a / int[] a) 

    2. StringBuilder转换为
        sb.toString()
    
    3. char to string
        String.valueOf(char c);

stringBuilder
    1. String to StringBuffer using append() method or new StringBuilder(string)
    2. StringBuffer to String using toString() method
```