1. Java
		       jdk中的javac编译							        JVM
    Java源代码————————————————————> JVM可以理解的java字节码————————————————————>机器可执行的二进制机器码


2. JVM:
	1. 定义： Java虚拟机，在不同的系统中有不同类型，目的就是让Java字节码能产生同样的结果。


3. Java和C++区别：
	1. 都是面向对象，继承，封装，多态
	2. Java不提供指针来直接访问内存
	3. Java的类单继承，C++多重继承（但是Java的接口可以多继承）
	4. Java有自动内存管理机制，不需要程序员手动释放内存

4. 字符串常量和字符型常量区别：
	1. 字符串：双引号		字符型：单引号
	2. 字符型常量：相当于一个整型（ASCII） 字符串常量：代表一个地址值
	3. 字符常量占2字节，不随机器架构改变


5. Overriding and Overloading
	1. difference: 
		1. Overloading occurs when two or more methods in one class have the same method name but different parameters.
		2. Overriding means having two methods with the same method name and parameters (i.e., method signature). One of the methods is in the parent class and the other is in the child class.

	2. constructor 是否可被Override？
		1. 不能被override，但可以被overload


6. StringBuilder 和 StringBuffer区别
	1. 共同点：两者都继承父类AbstractStringBuilder
	2. 区别： 
		1. StringBuffer对方法加了同步锁，所以是线程安全的，但StringBuilder没有
		2. StringBuffer每次调用方法，都是对自身操作， 但StringBuilder重新new一个新对象，在新对象上操作

7. 包装类型和基本类型
	1. 定义：最简单的理解，基本类型有默认值，而包装类型初始为null。然后再根据这两个特性进行分业务使用，在阿里巴巴的规范里所有的POJO类必须使用包装类型，而在本地变量推荐使用基本类型。
	2. 基本类型：
		1. 整数：包括int、short、byte、long初始值为0。

		2. 浮点型：float、double初始值为0.0

  		3. 字符：char初始值为空格，即'' "，如果输出，在Console上是看不到效果的。

		4. 布尔：boolean初始值为false 
	3. 包装类：
		1. Integer 、Long、Short、Byte、Character、Double、Float、Boolean、BigInteger、BigDecmail

	4. 基本类型与包装类型的异同：
		
		1、在Java中，一切皆对象，但八大基本类型却不是对象。
		
		2、声明方式的不同，基本类型无需通过new关键字来创建，而封装类型需new关键字。
		
		3、存储方式及位置的不同，基本类型是直接存储变量的值保存在堆栈中能高效的存取，封装类型需要通过引用指向实例，具体的实例保存在堆中。
		
		4、初始值的不同，封装类型的初始值为null，基本类型的的初始值视具体的类型而定，比如int类型的初始值为0，boolean类型为false；
		
		5、使用方式的不同，比如与集合类合作使用时只能使用包装类型。
		
		6、什么时候该用包装类，什么时候用基本类型，看基本的业务来定：这个字段允不允许null值，如果允许null值，则必然要用封装类，否则值类型就可以了，用到比如泛型和反射调用函数.，就需要用包装类！ 
	


		
8. 自动装箱和拆箱
	1. 自动装箱
    	在Java SE5之前，如果要生成一个数值为10的Integer对象，必须这样进行：
    	`Integer i = new Integer(10);`
    	而在从Java SE5开始就提供了自动装箱的特性，如果要生成一个数值为10的Integer对象，只需要这样就可以了：
        `Integer i = 10;`
    　　这个过程中会自动根据数值创建对应的 Integer对象，这就是装箱。
    2. 拆箱
    　　1. 定义： 那什么是拆箱呢？顾名思义，跟装箱对应，就是自动将包装器类型转换为基本数据类型：
	```
    Integer i = 10;  //装箱
    int n = i;   //拆箱
	```
    3. 简单一点说，装箱就是  自动将基本数据类型转换为包装器类型；拆箱就是  自动将包装器类型转换为基本数据类型。



8. 静态变量和成员变量

	1. 静态变量：大家共享； 成员变量：每个对象各不相同
	2. 代码：
	

```

		class Person{		  
		   String name; //成员变量，实例变量
		   static String country = "CN";//静态变量，类变量
		   public void show(){
			   System. out.println(country + ":" + name);
		 	   System.out.println(Person.country+ ":" + this.name);
		   }
		}

```

9. 静态方法：
	1. 调用静态对象，直接类名后加点就行。
		所以静态方法在这个类里面本身就存在，不用new一个对象。因为他是先于非静态成员存在的，所以静态方法不能调用非静态成员，反之可以。

10. 在Java中定义一个不做事且没有参数的构造方法的作用
	Java在执行子类构造方法时候，会调用父类无参构造（如果没有用super()来调用父类的构造方法）。父类如果只定义了有参构造，子类的构造方法中又没有用super去调用，就会报错。 

11. extends， implements区别
	1. Extends可以理解为全盘继承了父类的功能。 接口也可以用extends去继承接口
	2. implements可以理解为为这个类附加一些额外的功能；interface定义一些方法,并没有实现,需要implements来实现才可用。

12. 接口和抽象类的区别：

```

		接口																抽象类
    接口的方法默认是public，所有方法在接口中都不能实现。					抽象类可以有抽象方法，非抽象方法
	接口中除了static，final变量，不能有其他变量。						抽象类则不一定
	一个类可以实现多个接口											一个类只能实现一个抽象类

```

13. 成员变量和局部变量

```
			成员变量														局部变量
			
			属于类													    属于方法
		可以被public，private等修饰									只能被final修饰
		属于方法的，随着方法的创建而产生								随着方法的调用自动消失
		没有初始值，会被自动赋值										不会自动赋值

```


----------



1. == and equals()		 	
    1. equals是超类Object中的一个方法，其源码为
```
   
   public boolean equals(Object obj) {
                       return (this == obj);
                   }

```
    不重写equals方法，等价于==， 比较的是地址值
    											
	1. == 一般判断的是两个变量的地址是否相等。 == 比较基本数据类型比较的是值，引用数据类型比较的是内存
	2. equals()：
		1. 类没有覆盖equals(),等价于 == 
		2. 类覆盖了equals(),比较的是值
    3. 通过前面的分析，我们知道在Object类中，hashCode方法是通过Object对象的地址计算出来的，因为Object对象只与自身相等，
    所以同一个对象的地址总是相等的，计算取得的哈希码也必然相等，对于不同的对象，由于地址不同，所获取的哈希码自然也不会相等。
    因此到这里我们就明白了，如果一个类重写了equals方法，但没有重写hashCode方法，将会直接违法了第2条规定，这样的话，如果我们通过映射表(Map接口)操作相关对象时，就无法达到我们预期想要的效果。
       ————————————————
       原文链接：https://blog.csdn.net/javazejian/java/article/details/51348320

2. hashCode()
	1. 作用：获取哈希码，或散列码；该码是int类型，确定了该对象在哈希表中的索引位置	
	2. java的任何类都会有hashCode()函数
	3. 把对象放到hashset时候，会先看哈希码是否相同，如果想通再用equals判断值是否相同
	4. 两个对象hashcode相同，也不一定相等，但equals相同一定相等 
    




3. 线程，进程：
	1. 一个进程在执行中可以产生多个线程
	2. 同类的线程共享一块内存空间和一组系统资源
	3. 进程是程序的一次执行过程，是系统运行程序的基本单位


4. 线程状态
	1. ![](https://i.imgur.com/cHCfJIU.png)
	2. Runnable：线程创建之后处于NEW状态，调用start开始运行，这时候线程会处于READY状态。可运行状态的线程获得了CPU时间片（timeslice）后就处于RUNNING状态。
		ready和running都是runnable状态
	3. Waitting： 当线程执行wait()方法，就回进入WAITING状态，需要依靠其他线程的通知才能返回运行状态。
	4. TimeWaiting状态： 和Waitting状态区别是，在waiting状态加入了超时限制； 通过sleep(),wait方法可以把线程置于该状态。
	5. BLOCKED： 当调用同步方法，还未获得锁时候，会进入该状态

5. final
	1. final修饰变量： 基本数据类型一旦初始化后就不能更改，引用类型给定初始值就不能再让其指向另一个对象
	2. 修饰类： 该类不能再被继承，该类所有成员方法都被指定为final方法

6. HashMap
	1. 基本特点
		1. 非线程安全的
		2. null可以作为键，但只能有一个
		3. 初始容量为16，每次扩充2倍。（总是使用2的幂作为哈希表的大小，因为每次都是位运算扩充）
		4. 冲突问题：一开始为链表，当大于阈值（8）的时候，转化为红黑树
	2. 底层实现
		1. 数组和链表结合（链表散列）：key的hashcode经过扰动函数处理后得到hash值，然后判断该元素位置。如果该位置有元素，如果相同直接覆盖，不同就拉链解决冲突
		2. 当加链大于 8 时候，就将链表转化为红黑树
	
7. HashSet：
	1. 基本特点
		1. 底层就是基于hashMap实现的，除了个别方法，大部分都是调用hashmap方法
		2. 使用成员对象来计算hashcode值，对于两个对象相等hashcode，会用equals去判断相等性

	2. HashMap的长度为什么是2的幂次方
		![](https://i.imgur.com/cHmG7yw.png)

8. HashTable 和 ConcurrentHashMap锁区别
	1. ConcurrentHashMap对单个node上锁
	2. HashTable对整个表上锁
	![](https://i.imgur.com/kWigUEe.png)
	![](https://i.imgur.com/fESqvP3.png)


1. 底层实现： 
	1. List
		1. ArrayList: Object数组； 
		2. LinkedList: 双向链表；

	2. Set
		1. HashSet: HashMap
		2. LinkedHashSet: LinkedHashMap
		3. TreeSet: 红黑树
	3. Map
		1. HashMap: 数组+链表。 链表主要解决哈希冲突，超过8改为红黑树
		2. LinkedHashMap: 增加了一条双向链表，使得上面的结构可以保持键值对的插入顺序。同时通过对链表进行相应的操作，实现了访问顺序相关逻辑。
		![](https://i.imgur.com/wN4Vh23.png)