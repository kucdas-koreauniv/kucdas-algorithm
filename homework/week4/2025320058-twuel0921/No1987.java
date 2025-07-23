import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//알파벳 풀이 코드
public class No1987 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] map = new char[r][c];
        for(int i = 0; i < r; i++) {
            String line = sc.next();
            for(int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        Set<Character> visitSet = new HashSet<>();
        visitSet.add(map[0][0]);
        System.out.println(getMaxLength(map, visitSet, r, c, 0, 0, 1));
    }
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    private static int getMaxLength(char[][] map, Set<Character> visitSet, int r, int c, int row ,int col, int length) {
        int max = length;
        for(int i = 0; i < 4; i++) {
            int nextRow = row+dir[i][0];
            int nextCol = col+dir[i][1];
            if(nextRow >= 0 && nextRow < r && nextCol >= 0 && nextCol < c && !visitSet.contains(map[nextRow][nextCol])) {
                visitSet.add(map[nextRow][nextCol]);
                max = Math.max(max, getMaxLength(map, visitSet, r, c, nextRow, nextCol, length+1));
                visitSet.remove(map[nextRow][nextCol]);
            }
        }
        return max;
    }
}