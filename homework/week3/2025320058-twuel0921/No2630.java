import java.util.*;

//색종이 만들기 풀이 코드
public class No2630 {
    static int[][] arr;
    static int[] ans = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
        search(0, 0, n);
        System.out.println(ans[0]+"\n"+ans[1]);
    }

    private static void search(int x, int y, int size) {
        int anchor = arr[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(arr[i][j] != anchor) {
                    search(x, y, size / 2);
                    search(x + size / 2, y, size / 2);
                    search(x, y + size / 2, size / 2);
                    search(x + size / 2, y + size / 2, size / 2);
                    return;
                }
            }
        }
        ans[anchor]++;
    }
}