import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N과 M (2) 풀이 코드
public class No15650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];

        printAllSequence(arr, 0, 0, n, m);
    }

    private static void printAllSequence(int[] arr, int at, int depth, int n, int m) {
        if(depth == m) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = at; i < n; i++) {
            arr[depth] = i+1;
            printAllSequence(arr, i + 1, depth+1, n, m);
        }
    }
}