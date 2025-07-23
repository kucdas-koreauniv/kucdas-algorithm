import java.io.*;

//별 찍기 - 10 풀이 코드
public class No2447 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        solve(0, 0, n, false);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void solve(int x, int y, int n, boolean blank) {
        if(blank) {
            for(int i = x; i < x + n; i++){
                for(int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if(n == 1) {
            arr[x][y] = '*';
            return;
        }

        int count = 0;
        for(int i = x; i < x + n; i += n / 3) {
            for(int j = y; j < y + n; j += n / 3) {
                count++;
                if(count == 5) solve(i, j, n / 3, true);
                else solve(i, j, n / 3, false);
            }
        }
    }
}