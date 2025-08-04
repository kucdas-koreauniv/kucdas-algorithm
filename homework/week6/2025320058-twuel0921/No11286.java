import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//절댓값 힙 풀이 코드
public class No11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        AbsMinHeap heap = new AbsMinHeap();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if(x == 0) {
                sb.append(heap.heap.isEmpty() ? 0 : heap.pop()).append('\n');
            } else {
                heap.push(x);
            }
        }
        System.out.print(sb);
    }
    private static class AbsMinHeap {
        List<Integer> heap;
        public AbsMinHeap() {
            heap = new ArrayList<>();
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
            if(Math.abs(heap.get(parent)) > Math.abs(heap.get(node))) {
                int temp = heap.get(parent);
                heap.set(parent, heap.get(node));
                heap.set(node, temp);
                heapifyUp(parent);
            } else if(Math.abs(heap.get(parent)) == Math.abs(heap.get(node))) {
                if(heap.get(parent) > heap.get(node)) {
                    int temp = heap.get(parent);
                    heap.set(parent, heap.get(node));
                    heap.set(node, temp);
                    heapifyUp(parent);
                }
            }
        }
        public void heapifyDown(int node) {
            int left = node*2+1;
            int right = node*2+2;
            int min = node;
            if(left < heap.size() && Math.abs(heap.get(left)) < Math.abs(heap.get(min))) {
                min = left;
            }else if(left < heap.size() && Math.abs(heap.get(left)) == Math.abs(heap.get(min)) && heap.get(left) < heap.get(min)) {
                min = left;
            }
            if(right < heap.size() && Math.abs(heap.get(right)) < Math.abs(heap.get(min))) {
                min = right;
            }else if(right < heap.size() && Math.abs(heap.get(right)) == Math.abs(heap.get(min)) && heap.get(right) < heap.get(min)) {
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
}
