import java.util.Scanner;

//N번째 큰 수 풀이 코드
public class No2075 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        MaxHeap heap = new MaxHeap();
        for(int i = 0; i < n; i++) {
            heap.push(arr[n-1][i]);
        }
        int line = n-2;
        int count = 0;
        while(count < n-1 && line >= 0) {
            int curMax = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++) {
                curMax = Math.max(curMax, arr[line][i]);
            }
            while(curMax < heap.root()) {
                heap.pop();
                count++;
                if(count == n-1) {
                    break;
                }
            }
            for(int i = 0; i < n; i++) {
                heap.push(arr[line][i]);
            }
            line--;
        }
        System.out.print(heap.pop());
    }
}
