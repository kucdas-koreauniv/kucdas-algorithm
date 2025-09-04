import java.util.Scanner;

//섬의 개수
public class No4963 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w, h;
        StringBuilder sb = new StringBuilder();
        while(true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if(w == 0 && h == 0) {
                break;
            }
            int[][] map = new int[h][w];
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            int countIsland = 0;
            boolean[][] visited = new boolean[h][w];
            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        visitIsland(map, visited, w, h, i, j);
                        countIsland++;
                    }
                }
            }
            sb.append(countIsland).append("\n");
        }
        System.out.print(sb);
    }
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};
    private static void visitIsland(int[][] map, boolean[][] visited, int w, int h, int row, int col) {
        visited[row][col] = true;
        for(int i = 0; i < 8; i++) {
            int nextRow = row+dir[i][0];
            int nextCol = col+dir[i][1];
            if(nextRow < 0 || nextRow >= h
                || nextCol < 0 || nextCol >= w) {
                continue;
            }
            if(!visited[nextRow][nextCol] && map[nextRow][nextCol] == 1) {
                visitIsland(map, visited, w, h, nextRow, nextCol);
            }
        }
    }
}
