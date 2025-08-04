import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    List<Integer> heap;
    public MaxHeap() {
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
        if(heap.get(parent) < heap.get(node)) {
            int temp = heap.get(parent);
            heap.set(parent, heap.get(node));
            heap.set(node, temp);
            heapifyUp(parent);
        }
    }
    public void heapifyDown(int node) {
        int left = node*2+1;
        int right = node*2+2;
        int max = node;
        if(left < heap.size() && heap.get(left) > heap.get(max)) {
            max = left;
        }
        if(right < heap.size() && heap.get(right) > heap.get(max)) {
            max = right;
        }
        if(max != node) {
            int temp = heap.get(max);
            heap.set(max, heap.get(node));
            heap.set(node, temp);
            heapifyDown(max);
        }
    }
}

