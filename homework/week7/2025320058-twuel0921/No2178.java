import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//미로 탑색 풀이 코드
public class No2178 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maze = new int[n][m];
        for(int i = 0; i < n; i++) {
            String line = sc.next();
            for(int j = 0; j < m; j++) {
                maze[i][j] = line.charAt(j)-'0';
            }
        }
        int[][] depth = new int[n][m];
        findCount(n, m, maze, depth);
        System.out.println(depth[n-1][m-1]);
    }
    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    private static void findCount(int n, int m, int[][] maze, int[][] depth) {
        Queue<int[]> queue = new LinkedList<>();
        depth[0][0] = 1;
        queue.add(new int[] {0,0});
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nextRow = pos[0]+dir[i][0];
                int nextCol = pos[1]+dir[i][1];
                if(nextRow < 0 || nextRow >= n
                        || nextCol < 0 || nextCol >= m) {
                    continue;
                }
                if(maze[nextRow][nextCol] == 0
                        || depth[nextRow][nextCol] != 0) {
                    continue;
                }
                depth[nextRow][nextCol] = depth[pos[0]][pos[1]] + 1;
                queue.add(new int[] {nextRow,nextCol});
            }
        }
    }
}