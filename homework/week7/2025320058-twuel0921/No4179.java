import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//불! 풀이 코드
public class No4179 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] map = new int[r][c];
        int[] jihun = null;
        List<int[]> fire = new ArrayList<>();
        for(int i = 0; i < r; i++) {
            String line = sc.next();
            for(int j = 0; j < c; j++) {
                char ch = line.charAt(j);
                switch(ch) {
                    case '#':
                        map[i][j] = -1;
                        break;
                    case '.':
                        map[i][j] = 0;
                        break;
                    case 'J':
                        map[i][j] = 1;
                        jihun = new int[] {i,j};
                        break;
                    case 'F':
                        map[i][j] = -1;
                        fire.add(new int[] {i,j});
                        break;
                }
            }
        }
        System.out.println(escapeFromFire(map,jihun,fire,r,c));
    }
    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    private static String escapeFromFire(int[][] map, int[] jihun, List<int[]> fire, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(jihun);
        queue.addAll(fire);
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int current = map[pos[0]][pos[1]];
            if(current > 0) {
                for(int i = 0; i < 4; i++) {
                    int nextRow = pos[0]+dir[i][0];
                    int nextCol = pos[1]+dir[i][1];
                    if(isOutside(nextRow,nextCol,r,c)) {
                        return Integer.toString(current);
                    }
                    if(map[nextRow][nextCol] == 0) {
                        map[nextRow][nextCol] = current+1;
                        queue.add(new int[] {nextRow,nextCol});
                    }
                }
            }else {
                for(int i = 0; i < 4; i++) {
                    int nextRow = pos[0]+dir[i][0];
                    int nextCol = pos[1]+dir[i][1];
                    if(isOutside(nextRow,nextCol,r,c)) {
                        continue;
                    }
                    if(map[nextRow][nextCol] >= 0) {
                        map[nextRow][nextCol] = -1;
                        queue.add(new int[] {nextRow,nextCol});
                    }
                }
            }
        }
        return "IMPOSSIBLE";
    }
    private static boolean isOutside(int row, int col, int r, int c) {
        return row < 0 || row >= r
                || col < 0 || col >= c;
    }
}
