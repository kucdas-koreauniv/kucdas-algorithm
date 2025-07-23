import java.util.Arrays;
import java.util.Scanner;

//알파벳 풀이 코드
public class No1987 {
    static int r, c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        char[][] map = new char[r][c];
        for(int i = 0; i < r; i++) {
            String line = sc.next();
            for(int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        boolean[] visited = new boolean[26];
        Arrays.fill(visited, false);
        visited[map[0][0]-'A'] = true;
        System.out.println(getMaxLength(map, visited, 0, 0, 1));
    }
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    private static int getMaxLength(char[][] map, boolean[] visited, int row ,int col, int length) {
        int max = length;
        for(int i = 0; i < 4; i++) {
            int nextRow = row+dir[i][0];
            int nextCol = col+dir[i][1];
            if(nextRow >= 0 && nextRow < r && nextCol >= 0 && nextCol < c && !visited[map[nextRow][nextCol]-'A']) {
                visited[map[nextRow][nextCol]-'A'] = true;
                max = Math.max(max, getMaxLength(map, visited, nextRow, nextCol, length+1));
                visited[map[nextRow][nextCol]-'A'] = false;
            }
        }
        return max;
    }
}