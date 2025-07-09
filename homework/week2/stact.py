stack = []
MAX_SIZE = 100

def isFull(stack):
    return len(stack) == MAX_SIZE

def isEmpty(stack):
    return len(stack) == 0

def push(stack,element):
    if isFull:
        return
    stack.append(element)

def pop(stack):
    if isEmpty(stack):
        return
    stack.pop()
