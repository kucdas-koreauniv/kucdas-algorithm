public class Stack<T> {
    private final int MAX_SIZE = 100;
    private int top = -1;
    private Object[] elemetArray;

    public Stack() {
        elemetArray = new Object[MAX_SIZE];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == MAX_SIZE-1;
    }

    public T peek() {
        return (T) elemetArray[top];
    }

    public T push(T item) {
        if(isFull()) {
            throw new ArrayIndexOutOfBoundsException("Full Stack!");
        }
        elemetArray[++top] = item;
        return item;
    }

    public T pop() {
        if(isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Empty Stack!");
        }
        return (T) elemetArray[top--];
    }
}