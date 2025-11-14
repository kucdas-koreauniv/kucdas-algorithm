import java.util.Arrays;
import java.util.Scanner;

//222-풀링 풀이 코드
public class No17829 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(poolArr(arr, 0, 0, n));
    }
    private static int poolArr(int[][] arr, int row, int col, int size) {
        if(size == 1) {
            return arr[row][col];
        }
        int[] part = new int[4];
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                part[i*2+j] = poolArr(arr, row+i*size/2, col+j*size/2, size/2);
            }
        }
        Arrays.sort(part);
        return part[2];
    }
}