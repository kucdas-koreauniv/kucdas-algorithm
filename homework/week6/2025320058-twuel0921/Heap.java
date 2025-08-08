import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Heap<T> {
    private final List<T> heap;
    private final Comparator<T> comparator;
    public Heap(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }
    public T root() {
        return this.heap.get(0);
    }
    public boolean isEmpty() {
        return this.heap.isEmpty();
    }
    public int size() {
        return this.heap.size();
    }
    public void push(T x) {
        heap.add(x);
        heapifyUp(heap.size()-1);
    }
    public T pop() {
        T root = heap.get(0);
        T last = heap.get(heap.size()-1);
        heap.set(0, last);
        heap.remove(heap.size()-1);
        heapifyDown(0);
        return root;
    }
    public void heapifyUp(int node) {
        if(node <= 0) {
            return;
        }
        int parent = (node-1)/2;
        if(comparator.compare(heap.get(parent), heap.get(node)) < 0) {
            T temp = heap.get(parent);
            heap.set(parent, heap.get(node));
            heap.set(node, temp);
            heapifyUp(parent);
        }
    }
    public void heapifyDown(int node) {
        int left = node*2+1;
        int right = node*2+2;
        int highPriorityNode = node;
        if(left < heap.size() && comparator.compare(heap.get(left), heap.get(highPriorityNode)) > 0) {
            highPriorityNode = left;
        }
        if(right < heap.size() && comparator.compare(heap.get(right), heap.get(highPriorityNode)) > 0) {
            highPriorityNode = right;
        }
        if(highPriorityNode != node) {
            T temp = heap.get(highPriorityNode);
            heap.set(highPriorityNode, heap.get(node));
            heap.set(node, temp);
            heapifyDown(highPriorityNode);
        }
    }
}

