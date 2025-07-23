import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N과 M (1) 풀이 코드
public class No15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n];
        int[] arr = new int[m];

        printAllComb(arr, visited, n, m, 0);
    }

    private static void printAllComb(int[] arr, boolean[] visited, int n, int m, int depth) {
        if(depth == m) {
            for(int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i+1;
                printAllComb(arr, visited, n, m, depth+1);
                visited[i] = false;
            }
        }
    }
}