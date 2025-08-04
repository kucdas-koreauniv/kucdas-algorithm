import java.util.Scanner;

//중앙값 구하기 풀이 코드
public class No2696 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int m = sc.nextInt();
            MinHeap min = new MinHeap();
            MaxHeap max = new MaxHeap();
            sb.append(m/2+1).append('\n');
            for(int i = 0; i < m; i++) {
                pushToHeap(min, max, sc.nextInt());
                if(i % 2 == 0) {
                    sb.append(max.root()).append(i % 18 == 0 && i != 0 ? '\n' : ' ');
                }
            }
            sb.append('\n');
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
