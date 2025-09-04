import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//적록색약 풀이 코드
public class No10026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        int resultNormal = 0;
        int resultColorBlind = 0;
        boolean[][] visitedNormal = new boolean[n][n];
        boolean[][] visitedColorBlind = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visitedNormal[i][j]) {
                    getBlockCount(map, visitedNormal, i, j, false);
                    resultNormal++;
                }
                if(!visitedColorBlind[i][j]) {
                    getBlockCount(map, visitedColorBlind, i, j, true);
                    resultColorBlind++;
                }
            }
        }

        System.out.println(resultNormal + " " + resultColorBlind);
    }
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    private static void getBlockCount(char[][] map, boolean[][] visited, int row, int col, boolean isColorBlind) {
        char color = map[row][col];
        visited[row][col] = true;
        for(int i = 0; i < 4; i++) {
            int nextRow = row + dir[i][0];
            int nextCol = col + dir[i][1];
            if(nextRow < 0 || nextCol < 0
                    || nextRow >= map.length || nextCol >= map.length) {
                continue;
            }
            char nextColor = map[nextRow][nextCol];
            if(isColorBlind) {
                if(!visited[nextRow][nextCol] && ((color != 'B' && nextColor != 'B') || (color == 'B' && nextColor == 'B'))) {
                    getBlockCount(map, visited, nextRow, nextCol, true);
                }
            }else {
                if(!visited[nextRow][nextCol] && color == nextColor) {
                    getBlockCount(map, visited, nextRow, nextCol, false);
                }
            }
        }
    }
}