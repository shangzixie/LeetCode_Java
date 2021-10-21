var Node = function(key, value) {
  this.key = key;
  this.val = value;
  this.prev = this.next = null;
}

var DoublyLinkedList = function() {
    this.dummy = new Node();
    this.tail = new Node();
    this.dummy.next = this.tail;
    this.tail.prev = this.dummy;
}

DoublyLinkedList.prototype.addToTail = function(node) {
    const preNode = this.tail.prev;
    preNode.next = node;
    node.prev = preNode;

    this.tail.prev = node;
    node.next = this.tail;
}

DoublyLinkedList.prototype.moveToTail = function(node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
    this.addToTail(node);
}

DoublyLinkedList.prototype.deleteHead = function() {
    let nodeRemoved = this.dummy.next;
    let newHead = nodeRemoved.next;
    this.dummy.next = newHead;
    newHead.prev = this.dummy;

    return nodeRemoved;
}

/**
 * @param {number} capacity
 */
var LRUCache = function(capacity) {
    this.capacity = capacity;
    this.map = new Map();
    this.size = 0;
    this.dll = new DoublyLinkedList();
};

/**
 * @param {number} key
 * @return {number}
 */
LRUCache.prototype.get = function(key) {
    if (!this.map.get(key)) return -1;

    this.dll.moveToTail(this.map.get(key))
    return this.map.get(key).val;
};

/**
 * @param {number} key
 * @param {number} value
 * @return {void}
 */
LRUCache.prototype.put = function(key, value) {
    if(!this.map.has(key)) {
        this.size += 1;
        let node = new Node(key, value);
        this.map.set(key, node);
        this.dll.addToTail(node);

        if (this.size > this.capacity) {
            this.map.delete(this.dll.deleteHead().key);
        }
        return;
    }
    this.map.get(key).val = value;
    this.dll.moveToTail(this.map.get(key));
};


/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */