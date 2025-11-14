import java.util.Comparator;
import java.util.Scanner;

//절댓값 힙 풀이 코드
public class No11286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        /**Comparator를 통한 구현으로 구조가 충분히 정리되었다 생각합니다.
        혹시 이 이상으로 정리해야 할까요?**/
        Heap<Integer> heap = new Heap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)) {
                    return o2-o1;
                }
                return Math.abs(o2) - Math.abs(o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if(x == 0) {
                sb.append(heap.isEmpty() ? 0 : heap.pop()).append('\n');
            } else {
                heap.push(x);
            }
        }
        System.out.print(sb);
    }
}
