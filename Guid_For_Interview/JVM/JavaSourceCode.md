## difference between Vector and ArrayList
    1. 都是底层动态数组实现
    2. ArrayList每次增加1.5倍，vector增加2倍
    3. Vector多了一个构造方法
            public Vector(int initialCapacity,int capacityIncrement)
        扩容的话oldcapasity + capacityIncrement
        或者未指定时候，oldcapasity + oldcapasity
    4. Vector被 synchronized修饰，线程安全
    
##ArrayList

##HashMap
    1. 底层是数组，每个元素是Node<K, V> 
    2. 哈希冲突8以下为链表，超过8为红黑树
    3. threshold = loadFactor * capasity
    4. 初始容量为0， 放入第一个元素时候扩充为16
    5. loadFactor = 0.75
##HashSet
    1. 就是调用一个HashMap
    2. 然后value为: private static final Object PRESENT = new Object();
    其value是一个final修饰的object对象
    3. HashSet也是线程不安全的，我们可以使用Set s = Collections.synchronizedSet（new HashSet（...））包装一个线程安全的Set

##LinkedHashMap
    1. LinkedHashMap和HashMap的构造方法差不多，区别在于多了一个accessOrder
    2. LinkedHashMap通过在HashMap的基础上增加一条双向链表，实现了插入顺序和访问顺序一致。实现的核心是静态内部类LinkedHashMap.Entry，LinkedHashMap.Entry继承至HashMap的静态内部类HashMap.Node。Entry拥有Node的所有属性，并且在此基础上增加了前节点和后节点两个属性。所有对底层HashMap数据结构修改的地方都会修改该链表进行修改,遍历的时候便是遍历这一条有序的链表。需要注意的是get()方法在accessOrder为true的时候也会对底层结构进行修改。
    3. 基于get()在accessOrder为true时，会将访问到的元素放到链表的最后的特性，我们可以使用LinkedHashMap实现LRU缓存。
    4. LinkedHashMap同HashMap一样，线程不安全。