import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//카드 합체 놀이 풀이 코드
public class No15903 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Heap<Long> heap = new Heap<>((o1, o2) -> -o1.compareTo(o2));
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i = 0; i < n; i++) {
            heap.push(sc.nextLong());
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
}
