import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//연구소 풀이 코드
public class No14502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        List<int[]> virus = new ArrayList<>();
        List<int[]> space = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 2) {
                    virus.add(new int[] {i,j});
                }else if(map[i][j] == 0) {
                    space.add(new int[] {i,j});
                }
            }
        }
        System.out.println(getMaxSafeArea(map, virus, space, n, m, -1, 0));
    }
    private static int countSafeArea(int[][] map, int n, int m) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    private static void spreadVirus(int[][] map, boolean[][] visited, int n, int m, int row, int col) {
        visited[row][col] = true;
        for(int i = 0; i < 4; i++) {
            int nextRow = row + dir[i][0];
            int nextCol = col + dir[i][1];
            if(nextRow < 0 || nextRow >= n
                || nextCol < 0 || nextCol >= m) {
                continue;
            }
            if(map[nextRow][nextCol] == 0) {
                map[nextRow][nextCol] = 2;
                spreadVirus(map, visited, n, m, nextRow, nextCol);
            }
        }
    }
    private static int getMaxSafeArea(int[][] map, List<int[]> virus, List<int[]> space, int n, int m, int start, int numWall) {
        if(numWall == 3) {
            int[][] copy = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    copy[i][j] = map[i][j];
                }
            }
            for(int[] v : virus) {
                spreadVirus(copy, new boolean[n][m], n, m, v[0], v[1]);
            }
            return countSafeArea(copy, n, m);
        }
        int max = 0;
        for(int i = start+1; i < space.size(); i++) {
            int[] s = space.get(i);
            map[s[0]][s[1]] = 1;
            max = Math.max(max, getMaxSafeArea(map, virus, space, n, m, i, numWall+1));
            map[s[0]][s[1]] = 0;
        }
        return max;
    }
}