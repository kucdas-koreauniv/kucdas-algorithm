import java.util.Arrays;
import java.util.Scanner;

//단지번호붙이기 풀이 코드
public class No2667 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        int block = 2;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1) {
                    dfs(map, i, j, block);
                    block++;
                }
            }
        }
        int[] countBlock = new int[block -2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 0) {
                    continue;
                }
                countBlock[map[i][j]-2]++;
            }
        }
        System.out.println(countBlock.length);
        Arrays.sort(countBlock);
        for (int i : countBlock) {
            System.out.println(i);
        }
    }
    static int[] dx = {1,0,0,-1};
    static int[] dy = {0,1,-1,0};
    private static void dfs(int[][] map, int x, int y, int block) {
        map[x][y] = block;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= map.length
                    || ny < 0 || ny >= map.length) {
                continue;
            }
            if(map[nx][ny] == 1) {
                dfs(map, nx, ny, block);
            }
        }
    }
}