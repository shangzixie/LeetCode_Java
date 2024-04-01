class DequeWithStacks:
    def __init__(self):
        self.stack1 = []  # Front operations
        self.stack2 = []  # Back operations

    def pushFront(self, value):
        self.stack1.append(value)

    def pushBack(self, value):
        self.stack2.append(value)

    def popFront(self):
        if not self.stack1:
            while self.stack2:
                self.stack1.append(self.stack2.pop())
        if not self.stack1:
            raise IndexError("Pop from an empty deque")
        return self.stack1.pop()

    def popBack(self):
        if not self.stack2:
            while self.stack1:
                self.stack2.append(self.stack1.pop())
        if not self.stack2:
            raise IndexError("Pop from an empty deque")
        return self.stack2.pop()



# Example usage
deque = DequeWithStacks()
deque.pushFront(5)
deque.pushFront(4)
deque.pushFront(3)
deque.pushFront(2)
deque.pushFront(1)
deque.pushBack(6)
deque.pushBack(7)
deque.pushBack(8)
deque.pushBack(9)
# print(deque.popBack())
# print(deque.popBack())
# print(deque.popBack())
# print(deque.popBack())
# print(deque.popBack())
# print(deque.popBack())
# print(deque.popBack())
# print(deque.popBack())
# print(deque.popBack())

print(deque.popFront())
print(deque.popFront())
print(deque.popFront())
print(deque.popFront())
print(deque.popFront())
print(deque.popFront())
print(deque.popFront())
print(deque.popFront())
print(deque.popFront())
