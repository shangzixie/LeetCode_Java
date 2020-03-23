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
	1.共同点：两者都继承父类AbstractStringBuilder
	2.区别： 
		1. StringBuffer对方法加了同步锁，所以是线程安全的，但StringBuilder没有
		2. StringBuffer每次调用方法，都是对自身操作， 但StringBuilder重新new一个新对象，在新对象上操作

	


