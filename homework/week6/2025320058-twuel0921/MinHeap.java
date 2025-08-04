import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    List<Integer> heap;
    public MinHeap() {
        heap = new ArrayList<>();
    }
    public int root() {
        return heap.get(0);
    }
    public void push(int x) {
        heap.add(x);
        heapifyUp(heap.size()-1);
    }
    public int pop() {
        int root = heap.get(0);
        int last = heap.get(heap.size()-1);
        heap.set(0, last);
        heap.set(heap.size()-1, root);
        heap.remove(heap.size()-1);
        heapifyDown(0);
        return root;
    }
    public void heapifyUp(int node) {
        if(node <= 0) {
            return;
        }
        int parent = (node-1)/2;
        if(heap.get(parent) > heap.get(node)) {
            int temp = heap.get(parent);
            heap.set(parent, heap.get(node));
            heap.set(node, temp);
            heapifyUp(parent);
        }
    }
    public void heapifyDown(int node) {
        int left = node*2+1;
        int right = node*2+2;
        int min = node;
        if(left < heap.size() && heap.get(left) < heap.get(min)) {
            min = left;
        }
        if(right < heap.size() && heap.get(right) < heap.get(min)) {
            min = right;
        }
        if(min != node) {
            int temp = heap.get(min);
            heap.set(min, heap.get(node));
            heap.set(node, temp);
            heapifyDown(min);
        }
    }
}
