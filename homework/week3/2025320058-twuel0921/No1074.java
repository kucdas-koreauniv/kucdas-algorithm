import java.util.Scanner;

//Z 풀이 코드
public class No1074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = (1<<n);
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(findOrder(0, 0, size, r, c, 0));
    }
    private static int findOrder(int row, int col, int size, int r, int c, int num) {
        if(row == r && col == c) {
            return num;
        }
        int l = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                int nextRow = row+i*size/2;
                int nextCol = col+j*size/2;
                if(nextRow <= r && r < nextRow+size/2 && nextCol <= c && c < nextCol+size/2) {
                    return findOrder(nextRow, nextCol, size/2, r, c, num+l*(size/2*size/2));
                }
                l++;
            }
        }
        return -1;
    }
}