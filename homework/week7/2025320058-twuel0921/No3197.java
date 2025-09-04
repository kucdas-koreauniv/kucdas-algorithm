import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

//백조의 호수 풀이 코드
public class No3197 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][c];
        List<int[]> swan = new ArrayList<>();
        for(int i = 0; i < r; i++) {
            String line = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'L') {
                    map[i][j] = '.';
                    swan.add(new int[] {i,j});
                }
            }
        }
        System.out.println(findDaysToMeet(swan, map, r, c));
    }
    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    private static int findDaysToMeet(List<int[]> swan, char[][] map, int r, int c) {
        Queue<int[]> swanQueue = new LinkedList<>();
        Queue<int[]> swanNextQueue = new LinkedList<>();
        Queue<int[]> waterQueue = new LinkedList<>();
        Queue<int[]> waterNextQueue = new LinkedList<>();
        int[][] depth = new int[r][c];
        for(int i = 0; i < 2; i++) {
            int[] s = swan.get(i);
            swanQueue.add(new int[] {s[0],s[1],i+1});
        }
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == '.') {
                    waterQueue.add(new int[] {i,j});
                }
            }
        }
        int days = 0;
        while(true) {
            while(!swanQueue.isEmpty()) {
                int[] node = swanQueue.poll();
                int currentSwan = node[2];
                if (depth[node[0]][node[1]] != 0) continue;
                depth[node[0]][node[1]] = currentSwan;
                for(int i = 0; i < 4; i++) {
                    int nextRow = node[0] + dir[i][0];
                    int nextCol = node[1] + dir[i][1];
                    if (nextRow < 0 || nextRow >= r
                            || nextCol < 0 || nextCol >= c) {
                        continue;
                    }
                    if(map[nextRow][nextCol] == '.') {
                        if(depth[nextRow][nextCol] == 0) {
                            swanQueue.add(new int[] {nextRow,nextCol,currentSwan});
                        }else if(depth[nextRow][nextCol] != currentSwan) {
                            return days;
                        }
                    }else if(map[nextRow][nextCol] == 'X') {
                        swanNextQueue.add(new int[] {nextRow,nextCol,currentSwan});
                    }
                }
            }
            while(!waterQueue.isEmpty()) {
                int[] node = waterQueue.poll();
                for(int i = 0; i < 4; i++) {
                    int nextRow = node[0] + dir[i][0];
                    int nextCol = node[1] + dir[i][1];
                    if (nextRow < 0 || nextRow >= r
                            || nextCol < 0 || nextCol >= c) {
                        continue;
                    }
                    if(map[nextRow][nextCol] == 'X') {
                        map[nextRow][nextCol] = '.';
                        waterNextQueue.add(new int[] {nextRow,nextCol});
                    }
                }
            }
            swanQueue = swanNextQueue;
            waterQueue = waterNextQueue;
            swanNextQueue = new LinkedList<>();
            waterNextQueue = new LinkedList<>();
            days++;
        }
    }
}
