import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//바이러스 풀이 코드
public class No2606 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] computer = new int[n+1][n+1];
        boolean[] visited = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            computer[i][i] = 1;
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            computer[a][b] = computer[b][a] = 1;
        }
        findInfectedCom(computer, visited, n);
        int ans = 0;
        for(int i = 2; i <= n; i++)
            if(visited[i]) ans++;
        System.out.println(ans);
    }
    private static void findInfectedCom(int[][] computer, boolean[] visited, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()) {
            int node = q.poll();
            visited[node] = true;
            for(int i = 1; i <= n; i++) {
                if(computer[node][i] == 1 && !visited[i]) {
                    q.offer(i);
                }
            }
        }
    }
}