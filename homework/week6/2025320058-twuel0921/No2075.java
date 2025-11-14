import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N번째 큰 수 풀이 코드
public class No2075 {
    public static void main(String[] args) throws IOException {
        //이 문제도 Scanner 사용 시 시간초과가 터지네요..
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MaxHeap heap = new MaxHeap();
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                heap.push(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i = 0; i < n-1; i++) {
            heap.pop();
        }
        System.out.print(heap.pop());
    }
}
