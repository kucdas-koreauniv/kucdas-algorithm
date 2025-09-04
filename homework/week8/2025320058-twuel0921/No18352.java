import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//특정 거리의 도시 찾기 풀이 코드
public class No18352 {
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(new Edge(b, 1));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        getDist(graph, dist, x);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            if(dist[i] == k) {
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb.toString().isEmpty() ? "-1" : sb);
    }
    private static void getDist(List<List<Edge>> graph, int[] dist, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        dist[start] = 0;
        pq.add(new Edge(start, 0));
        while(!pq.isEmpty()) {
            Edge top = pq.poll();
            if(dist[top.to] < top.weight) {
                continue;
            }
            for(int i = 0; i < graph.get(top.to).size(); i++) {
                Edge next = graph.get(top.to).get(i);
                if(top.weight + next.weight < dist[next.to]) {
                    dist[next.to] = top.weight + next.weight;
                    pq.add(new Edge(next.to, top.weight + next.weight));
                }
            }
        }
    }
    private static class Edge {
        int to;
        int weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
