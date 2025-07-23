import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N과 M (3) 풀이 코드
public class No15651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[m];

        printAllSequence(sb, n, m, arr, 0);

        System.out.println(sb);
    }

    private static void printAllSequence(StringBuilder sb, int n, int m, int[] arr, int depth) {
        if(depth == m) {
            for(int i : arr) sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            arr[depth] = i + 1;
            printAllSequence(sb, n, m, arr, depth + 1);
        }
    }
}