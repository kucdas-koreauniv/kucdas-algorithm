import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//토마토 풀이 코드
public class No7569 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[][][] map = new int[h][n][m];
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    map[i][j][k] = sc.nextInt();
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(map[i][j][k] == 1) {
                        queue.offer(new int[] {i,j,k});
                    }
                }
            }
        }
        boolean[][][] visited = new boolean[h][n][m];
        searchTomato(map, queue, visited, h, n, m);
        int max = -1;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(map[i][j][k] == 0) {
                        max = 0;
                        continue;
                    }
                    max = max == 0 ? 0 : Math.max(max, map[i][j][k]);
                }
            }
        }
        System.out.println(max-1);
    }
    static int[][] dir = {{0,1,0},{0,-1,0},{0,0,1},{0,0,-1},{1,0,0},{-1,0,0}};
    private static void searchTomato(int[][][] map, Queue<int[]> queue, boolean[][][] visited, int h, int n, int m) {
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                visited[pos[0]][pos[1]][pos[2]] = true;
                for(int j = 0; j < 6; j++) {
                    int[] nextPos = {pos[0]+dir[j][0], pos[1]+dir[j][1], pos[2]+dir[j][2]};
                    if(isValid(nextPos, h, n, m) && !visited[nextPos[0]][nextPos[1]][nextPos[2]] && map[nextPos[0]][nextPos[1]][nextPos[2]] == 0) {
                        queue.offer(nextPos);
                        map[nextPos[0]][nextPos[1]][nextPos[2]] = map[pos[0]][pos[1]][pos[2]]+1;
                    }
                }
            }
        }
    }
    private static boolean isValid(int[] pos, int h, int n, int m) {
        return pos[0] >= 0 && pos[0] < h && pos[1] >= 0 && pos[1] < n && pos[2] >= 0 && pos[2] < m;
    }
}