import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//달이 차오른다, 가자. 풀이 코드
public class No1194 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] map = new char[n][m];
        int[] minsik = null;
        for(int i = 0; i < n; i++) {
            String line = sc.next();
            for(int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == '0') {
                    map[i][j] = '.';
                    minsik = new int[] {i,j};
                }
            }
        }
        System.out.println(escapeBeforeFullMoon(map,minsik,n,m));
    }
    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    private static int escapeBeforeFullMoon(char[][] map, int[] minsik, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        int[][][] depth = new int[n][m][(1<<6)];
        depth[minsik[0]][minsik[1]][0] = 1;
        queue.add(new int[] {minsik[0],minsik[1],0});
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int keySet = node[2];
            for(int i = 0; i < 4; i++) {
                int nextRow = node[0]+dir[i][0];
                int nextCol = node[1]+dir[i][1];
                if(nextRow < 0 || nextRow >= n
                        || nextCol < 0 || nextCol >= m) {
                    continue;
                }
                if(map[nextRow][nextCol] == '.' && depth[nextRow][nextCol][keySet] == 0) {
                    depth[nextRow][nextCol][keySet] = depth[node[0]][node[1]][keySet]+1;
                    queue.add(new int[] {nextRow,nextCol,keySet});
                }else if(map[nextRow][nextCol] == '1') {
                    return depth[node[0]][node[1]][keySet];
                }else if(isLowerCase(map[nextRow][nextCol])) {
                    int nextKeySet = keySet | (1 << map[nextRow][nextCol] - 'a');
                    if(depth[nextRow][nextCol][nextKeySet] == 0) {
                        depth[nextRow][nextCol][nextKeySet] = depth[node[0]][node[1]][keySet] + 1;
                        queue.add(new int[]{nextRow, nextCol, nextKeySet});
                    }
                }else if(isUpperCase(map[nextRow][nextCol])) {
                    int door = map[nextRow][nextCol]-'A';
                    if(hasKey(keySet,door) && depth[nextRow][nextCol][keySet] == 0) {
                        depth[nextRow][nextCol][keySet] = depth[node[0]][node[1]][keySet] + 1;
                        queue.add(new int[]{nextRow, nextCol, keySet});
                    }
                }
            }
        }
        return -1;
    }
    private static boolean isUpperCase(char ch) {
        return ch-'A' >= 0 && ch-'A' <= 5;
    }
    private static boolean isLowerCase(char ch) {
        return ch-'a' >= 0 && ch-'a' <= 5;
    }
    private static boolean hasKey(int ketSet, int key) {
        return ((ketSet) & (1<<key)) == (1<<key);
    }
}
