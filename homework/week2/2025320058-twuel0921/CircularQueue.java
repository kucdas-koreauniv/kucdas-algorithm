public class CircularQueue<T> {
    private final int MAX_SIZE = 100;
    private int front;
    private int rear;
    private int size;
    private Object[] elemetArray;

    public CircularQueue() {
        elemetArray = new Object[MAX_SIZE];
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public int size() {
        return size;
    }

    public T enqueue(T item) {
        if(isFull()) {
            throw new ArrayIndexOutOfBoundsException("Full Queue!");
        }
        elemetArray[rear] = item;
        rear = (rear+1)%MAX_SIZE;
        size++;
        return item;
    }

    public T dequeue() {
        if(isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Empty Queue!");
        }
        T item = (T) elemetArray[front];
        front = (front+1)%MAX_SIZE;
        size--;
        return item;
    }
}
