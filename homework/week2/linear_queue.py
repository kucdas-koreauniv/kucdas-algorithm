MAX_SIZE = 100
class queue:
    list = [MAX_SIZE]
    front = 0
    rear = 0

def isFull(queue):
    return queue.rear == MAX_SIZE

def isEmpty(queue):
    return queue.front == queue.rear

def enqueue(queue, element):
    if isFull:
        return
    queue.list[rear] = element
    rear += 1

def dequeue(queue):
    if isEmpty:
        return
    value = queue.list[front]
    front += 1
    return value