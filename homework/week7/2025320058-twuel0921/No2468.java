import java.util.Scanner;

//안전 영역 풀이 코드
public class No2468 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        int maxRain = -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                maxRain = Math.max(maxRain, map[i][j]);
            }
        }
        int maxSafety = 0;
        for(int rain = 0; rain <= maxRain; rain++) {
            int currentSafety = 0;
            boolean[][] visited = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j] && map[i][j] > rain) {
                        countSafetyArea(map, visited, rain, i, j);
                        currentSafety++;
                    }
                }
            }
            maxSafety = Math.max(maxSafety, currentSafety);
        }
        System.out.println(maxSafety);
    }
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    private static void countSafetyArea(int[][] map, boolean[][] visited, int rain, int row, int col) {
        visited[row][col] = true;
        for(int i = 0; i < 4; i++) {
            int nextRow = row+dir[i][0];
            int nextCol = col+dir[i][1];
            if(nextRow < 0 || nextRow >= map.length
                    || nextCol < 0 || nextCol >= map.length) {
                continue;
            }
            if(!visited[nextRow][nextCol] && map[nextRow][nextCol] > rain) {
                countSafetyArea(map, visited, rain, nextRow, nextCol);
            }
        }
    }
}
