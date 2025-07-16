MAX_SIZE = 100
class Queue:
    def __init__(self):
        self.list = [None] * MAX_SIZE
        self.front = 0
        self.rear = 0
        self.count = 0

q = Queue()

def isFull(q):
    return q.count == MAX_SIZE

def isEmpty(q):
    return q.count == 0

def enqueue(q, element):
    if isFull(q):
        return None
    q.list[q.rear] = element
    q.rear = (q.rear + 1) % MAX_SIZE
    q.count += 1

def dequeue(q):
    if isEmpty(q):
        return
    value = q.list[q.front]
    q.front = (q.front + 1) % MAX_SIZE
    q.count -= 1
    return value
    
