import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//N-Queen 풀이 코드
public class No9663 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] col = new int[n+1];
        System.out.println(findNQueen(n, 0, col));
    }
    private static int findNQueen(int n, int i, int[] col) {
        if(!isPromising(i, col)) {
            return 0;
        }
        int cnt_nQueen = 0;
        if(i == n) {
            return 1;
        }
        for(int j = 1; j <= n; j++) {
            col[i+1] = j;
            cnt_nQueen += findNQueen(n, i+1, col);
        }
        return cnt_nQueen;
    }

    private static boolean isPromising(int i, int[] col) {
        for(int j = 1; j < i; j++) {
            if(col[i] == col[j] || Math.abs(col[i] - col[j]) == i - j) {
                return false;
            }
        }

        return true;
    }
}