import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//유기농 배추 풀이 코드
public class No1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String[] line = br.readLine().split(" ");
            int m = Integer.parseInt(line[0]);
            int n = Integer.parseInt(line[1]);
            int k = Integer.parseInt(line[2]);
            int[][] map = new int[n][m];

            for(int j = 0; j < k; j++) {
                String[] pos = br.readLine().split(" ");
                int x = Integer.parseInt(pos[0]);
                int y = Integer.parseInt(pos[1]);
                map[y][x] = 1;
            }
            int count = 0;
            for(int y = 0; y < n; y++) {
                for(int x = 0; x < m; x++) {
                    if(map[y][x] == 1) {
                        countCabbage(map, m, n, y, x);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    private static void countCabbage(int[][] map, int m, int n, int y, int x) {
        map[y][x] = 0;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0
                    || nx >= m || ny >= n) {
                continue;
            }
            if(map[ny][nx] == 0) {
                continue;
            }
            countCabbage(map, m, n, ny, nx);
        }
    }
}