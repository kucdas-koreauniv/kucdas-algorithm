MAX_SIZE = 100
class queue:
    list = [MAX_SIZE]
    front = 0
    rear = 0
    count = 0

def isFull(queue):
    return queue.count == MAX_SIZE

def isEmpty(queue):
    return queue.count == 0

def enqueue(queue, element):
    if isFull:
        return
    queue.list[rear] = element
    rear = (rear + 1) % MAX_SIZE
    count += 1

def dequeue(queue):
    if isEmpty:
        return
    value = queue.list[front]
    front = (front + 1) % MAX_SIZE
    count -= 1
    return value
    
