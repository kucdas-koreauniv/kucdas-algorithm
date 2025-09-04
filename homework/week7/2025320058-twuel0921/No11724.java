import java.util.Scanner;

//연결 요소의 개수
public class No11724 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] visited = new boolean[n+1];
        int[][] arr = new int[n+1][n+1];
        int m = sc.nextInt();
        for(int i = 1; i <= n; i++) {
            arr[i][i] = 1;
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                findConnectedComponent(arr, visited, n, i);
                ans++;
            }
        }
        System.out.println(ans);
    }

    static void findConnectedComponent(int[][] arr, boolean[] visited, int n, int now) {
        for(int i = 1; i <= n; i++) {
            if(arr[now][i] == 1 && !visited[i]) {
                visited[i] = true;
                findConnectedComponent(arr, visited, n, i);
            }
        }
    }
}