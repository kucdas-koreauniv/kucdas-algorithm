import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//토마토 풀이 코드
public class No7576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1) {
                    queue.offer(new int[] {i,j});
                }
            }
        }
        boolean[][] visited = new boolean[n][m];
        searchTomato(map, queue, visited, n, m);
        int max = -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    max = 0;
                    continue;
                }
                max = max == 0 ? 0 : Math.max(max, map[i][j]);
            }
        }
        System.out.println(max-1);
    }
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    private static void searchTomato(int[][] map, Queue<int[]> queue, boolean[][] visited, int n, int m) {
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                visited[pos[0]][pos[1]] = true;
                for(int j = 0; j < 4; j++) {
                    int[] nextPos = {pos[0]+dir[j][0], pos[1]+dir[j][1]};
                    if(isValid(nextPos, n, m) && !visited[nextPos[0]][nextPos[1]] && map[nextPos[0]][nextPos[1]] == 0) {
                        queue.offer(nextPos);
                        map[nextPos[0]][nextPos[1]] = map[pos[0]][pos[1]]+1;
                    }
                }
            }
        }
    }
    private static boolean isValid(int[] pos, int n, int m) {
        return pos[0] >= 0 && pos[0] < n && pos[1] >= 0 && pos[1] < m;
    }
}