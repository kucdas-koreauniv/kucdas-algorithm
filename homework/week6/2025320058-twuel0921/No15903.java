import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//카드 합체 놀이 풀이 코드
public class No15903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinHeap heap = new MinHeap();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            heap.push(sc.nextInt());
        }
        for(int i = 0; i < m; i++) {
            long sumOfCard = heap.pop()+heap.pop();
            heap.push(sumOfCard);
            heap.push(sumOfCard);
        }
        long ans = 0;
        for(int i = 0; i < n; i++) {
            ans += heap.pop();
        }
        System.out.print(ans);
    }
    private static class MinHeap {
        List<Long> heap;
        public MinHeap() {
            heap = new ArrayList<>();
        }
        public long root() {
            return heap.get(0);
        }
        public void push(long x) {
            heap.add(x);
            heapifyUp(heap.size()-1);
        }
        public long pop() {
            long root = heap.get(0);
            long last = heap.get(heap.size()-1);
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
                long temp = heap.get(parent);
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
                long temp = heap.get(min);
                heap.set(min, heap.get(node));
                heap.set(node, temp);
                heapifyDown(min);
            }
        }
    }
}
