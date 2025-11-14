import java.util.Scanner;

//센티와 마법의 뿅망치 풀이 코드
public class No19638 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int t = sc.nextInt();
        MaxHeap heap = new MaxHeap();
        for(int i = 0; i < n; i++) {
            heap.push(sc.nextInt());
        }
        int count = 0;
        for(int i = 0; i < t; i++) {
            int max = heap.pop();
            if(max < h || max == 1) {
                heap.push(max);
                break;
            }else {
                count++;
                heap.push(max / 2);
            }
        }
        int max = heap.pop();
        System.out.println(max < h ? "YES" : "NO");
        System.out.print(max < h ? count : max);
    }
}
