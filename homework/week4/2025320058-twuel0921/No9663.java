import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//N-Queen 풀이 코드
public class No9663 {
    private static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] col = new int[n+1];
        System.out.println(findNQueen(0, col));
    }
    private static int findNQueen(int i, int[] col) {
        int cnt_nQueen = 0;
        if(isPromising(i, col)) {
            if(i == n) {
                return 1;
            }
            else {
                for(int j = 1; j <= n; j++) {
                    col[i+1] = j;
                    cnt_nQueen += findNQueen(i+1, col);
                }
            }
        }
        return cnt_nQueen;
    }

    private static boolean isPromising(int i, int[] col) {
        for(int j = 1; j < i; j++) {
            if(col[i] == col[j] || Math.abs(col[i] - col[j]) == i - j) return false;
        }

        return true;
    }
}