public class LinearQueue<T> {
    private final int MAX_SIZE = 100;
    private int front;
    private int rear;
    private Object[] elemetArray;

    public LinearQueue() {
        elemetArray = new Object[MAX_SIZE];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public int size() {
        return front-rear;
    }

    public T enqueue(T item) {
        if(rear == MAX_SIZE) {
            throw new ArrayIndexOutOfBoundsException("Full Queue!");
        }
        elemetArray[rear++] = item;
        return item;
    }

    public T dequeue() {
        if(isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Empty Queue!");
        }
        return (T) elemetArray[front++];
    }
}
