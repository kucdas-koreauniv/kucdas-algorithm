import java.util.Scanner;

//별 찍기 - 11 풀이 코드
public class No2448 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][2*n-1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2*n-1; j++) {
                map[i][j] = ' ';
            }
        }
        putStars(map, 0, 0, 2*n-1, n);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2*n-1; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
    private static void putStars(char[][] map, int row, int col, int width, int height) {
        if(height == 3) {
            String[] triangle = {"  *  ", " * * ", "*****"};
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 5; j++) {
                    map[row+i][col+j] = triangle[i].charAt(j);
                }
            }
            return;
        }
        putStars(map, row, col+width/4+1, width/2, height/2);
        putStars(map, row+height/2, col, width/2, height/2);
        putStars(map, row+height/2, col+width/2+1, width/2, height/2);
    }
}