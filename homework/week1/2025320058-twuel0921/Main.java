import java.util.*;

public class Main {
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        for(int i = 0; i < n; i++) {
            int[] sub = new int[m];
            Arrays.fill(sub, 0);
            boolean[] visited = new boolean[n];
            Arrays.fill(visited, false);
            sub[0] = arr[i];
            visited[i] = true;
            dfs(sub, visited, 1);
        }
    }

    //기본적인 dfs, backtracking
    private static void dfs(int[] sub, boolean[] visited, int len) {
        //부분수열의 길이와 dfs의 depth가 같아지면 부분수열을 출력하고 탐색을 종료한다.
        if(len == sub.length) {
            for(int i : sub) System.out.print(i + " ");
            System.out.println();
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            //i번째 원소가 방문되지 않았을 경우 방문 후 부분수열에 추가해준다.
            if(!visited[i]) {
                sub[len] = arr[i];
                visited[i] = true;
                dfs(sub, visited, len+1);
                //백트랙킹을 위한 재할당
                sub[len] = 0;
                visited[i] = false;
            }
        }
    }
}