import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//벽 부수고 이동하기
public class No2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            line = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j)-'0';
            }
        }
        System.out.println(countMove(map, new int[n][m][2], n, m));
    }
    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    private static int countMove(int[][] map, int[][][] depth, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        depth[0][0][0] = 1;
        queue.add(new int[] {0,0,0});
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nextRow = node[0]+dir[i][0];
                int nextCol = node[1]+dir[i][1];
                int brokeWall = node[2];
                if(nextRow < 0 || nextRow >= n
                        || nextCol < 0 || nextCol >= m) {
                    continue;
                }
                if(map[nextRow][nextCol] == 0 && depth[nextRow][nextCol][brokeWall] == 0) {
                    depth[nextRow][nextCol][brokeWall] = depth[node[0]][node[1]][brokeWall] + 1;
                    queue.add(new int[] {nextRow,nextCol,brokeWall});
                }
                if(map[nextRow][nextCol] == 1 && brokeWall == 0 && depth[nextRow][nextCol][1] == 0) {
                    depth[nextRow][nextCol][1] = depth[node[0]][node[1]][brokeWall] + 1;
                    queue.add(new int[] {nextRow,nextCol,1});
                }
            }
        }
        int distWithoutBreak = depth[n-1][m-1][0];
        int distWithBreak = depth[n-1][m-1][1];
        if(distWithoutBreak == 0 && distWithBreak == 0) {
            return -1;
        }else if(distWithBreak == 0) {
            return distWithoutBreak;
        }else if(distWithoutBreak == 0) {
            return distWithBreak;
        }else {
            return Math.min(distWithBreak,distWithoutBreak);
        }
    }
}
