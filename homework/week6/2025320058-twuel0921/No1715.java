import java.util.Scanner;

//카드 정렬하기 풀이 코드
public class No1715 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MinHeap heap = new MinHeap();
        for(int i = 0; i < n; i++) {
            heap.push(sc.nextInt());
        }
        long ans = 0;
        while(heap.heap.size() > 1) {
            int a = heap.pop();
            int b = heap.pop();
            ans += (a+b);
            heap.push(a+b);
        }
        System.out.print(ans);
    }
}
