import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//DFS와 BFS 풀이 코드
public class No1260 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(graph, v-1, new boolean[n]);
        System.out.println();
        bfs(graph, v-1, new boolean[n]);
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visited) {
        if(visited[start]) {
            return;
        }
        visited[start] = true;
        System.out.print((start+1) + " ");
        Integer[] arr = graph.get(start).toArray(new Integer[0]);
        Arrays.sort(arr);
        for(int next : arr) {
            dfs(graph, next, visited);
        }
    }

    private static void bfs(ArrayList<ArrayList<Integer>> graph, int start, boolean[] visited) {
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print((node+1) + " ");
            Integer[] arr = graph.get(node).toArray(new Integer[0]);
            Arrays.sort(arr);
            for(int next : arr) {
                if(!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}