## difference between Vector and ArrayList
    1. 都是底层动态数组实现
    2. ArrayList每次增加1.5倍，vector增加2倍
    3. Vector多了一个构造方法
            public Vector(int initialCapacity,int capacityIncrement)
        扩容的话oldcapasity + capacityIncrement
        或者未指定时候，oldcapasity + oldcapasity
    4. Vector被 synchronized修饰，线程安全
    
##ArrayList
    1. 底层为动态数组
    2. 每次都要重新复制
    3. 默认初始容量为 DEFAULT_CAPACITY = 10； 
    
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
    
    
    
##Map如何实现线程安全
https://www.jianshu.com/p/d0b37b927c48

    1. Hashtable： 
        1. Hashtable是旧版本Java的遗留类，继承自另一个遗留类Dictionary，线程安全的实现方式为简单粗暴地给get和put等方法加上synchronized关键字
        2. Hashtable容器使用synchronized来保证线程安全，但在线程竞争激烈的情况下Hashtable的效率非常低下。
        因为当一个线程访问Hashtable的同步方法时，其他线程访问Hashtable的同步方法时，可能会进入阻塞或轮询状态。
        如线程1使用put进行添加元素，线程2不但不能使用put方法添加元素，并且也不能使用get方法来获取元素，所以竞争越激烈效率越低。
        
    2. ConcurrentHashMap
        1. HashTable容器在竞争激烈的并发环境下表现出效率低下的原因，是因为所有访问HashTable的线程都必须竞争同一把锁，
        那假如容器里有多把锁，每一把锁用于锁容器其中一部分数据，那么当多线程访问容器里不同数据段的数据时，线程间就不会存在锁竞争，
        从而可以有效的提高并发访问效率，这就是ConcurrentHashMap所使用的锁分段技术，首先将数据分成一段一段的存储，然后给每一段数据配一把锁，
        当一个线程占用锁访问其中一个段数据的时候，其他段的数据也能被其他线程访问。
           
        2. 有些方法需要跨段，比如size()和containsValue()，它们可能需要锁定整个表而而不仅仅是某个段，这需要按顺序锁定所有段，操作完毕后，又按顺序释放所有段的锁
        
        3. JDK1.8的实现已经抛弃了Segment分段锁机制，利用CAS+Synchronized来保证并发更新的安全。数据结构采用：数组+链表+红黑树。
        
    3. Hashtable 和 ConcurrentHashMap
        1. ConcurrentHashMap 是一个并发散列映射表，它允许完全并发的读取，并且支持给定数量的并发更新。
           而HashTable和同步包装器包装的 HashMap，使用一个全局的锁来同步不同线程间的并发访问，同一时间点，只能有一个线程持有锁，也就是说在同一时间点，只能有一个线程能访问容器，这虽然保证多线程间的安全并发访问，但同时也导致对容器的访问变成串行化的了。
       
        2. Hashtable的任何操作都会把整个表锁住，是阻塞的。好处是总能获取最实时的更新，比如说线程A调用putAll写入大量数据，期间线程B调用get，线程B就会被阻塞，直到线程A完成putAll，因此线程B肯定能获取到线程A写入的完整数据。坏处是所有调用都要排队，效率较低。
           ConcurrentHashMap 是设计为非阻塞的。在更新时会局部锁住某部分数据，但不会把整个表都锁住。同步读取操作则是完全非阻塞的。好处是在保证合理的同步前提下，效率很高。坏处是严格来说读取操作不能保证反映最近的更新。例如线程A调用putAll写入大量数据，期间线程B调用get，则只能get到目前为止已经顺利插入的部分数据。
           应该根据具体的应用场景选择合适的HashMap。
           