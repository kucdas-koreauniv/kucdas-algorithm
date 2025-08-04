import java.util.Scanner;

//가운데를 말해요 풀이 코드
public class No1655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MinHeap min = new MinHeap();
        MaxHeap max = new MaxHeap();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            pushToHeap(min, max, sc.nextInt());
            sb.append(max.root()).append('\n');
        }
        System.out.print(sb);
    }
    private static void pushToHeap(MinHeap min, MaxHeap max, int x) {
        if(min.heap.isEmpty() && max.heap.isEmpty()) {
            max.push(x);
        } else if(max.root() < x) {
            min.push(x);
            balanceHeapSize(min, max);
        } else {
            max.push(x);
            balanceHeapSize(min, max);
        }
    }
    private static void balanceHeapSize(MinHeap min, MaxHeap max) {
        while(max.heap.size() - min.heap.size() > 1) {
            min.push(max.pop());
        }
        while(min.heap.size() - max.heap.size() > 0) {
            max.push(min.pop());
        }
    }
}
