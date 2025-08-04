import java.util.Scanner;

//최대 힙 풀이 코드
public class No11279 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MaxHeap heap = new MaxHeap();
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
}
