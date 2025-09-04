import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//중량제한 풀이 코드
public class No1939 {
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            graph.get(a).add(new Edge(b, w));
            graph.get(b).add(new Edge(a, w));
        }
        int[] dist = new int[n+1];
        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println(getMaxLimit(graph, dist, start, end));
    }
    private static int getMaxLimit(List<List<Edge>> graph, int[] dist, int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o.weight));
        dist[start] = INF;
        pq.add(new Edge(start, INF));
        while(!pq.isEmpty()) {
            Edge top = pq.poll();
            if(dist[top.to] > top.weight) {
                continue;
            }
            if(top.to == end) {
                return top.weight;
            }
            for(int i = 0; i < graph.get(top.to).size(); i++) {
                Edge next = graph.get(top.to).get(i);
                if(Math.min(top.weight, next.weight) > dist[next.to]) {
                    dist[next.to] = Math.min(top.weight, next.weight);
                    pq.add(new Edge(next.to, Math.min(top.weight, next.weight)));
                }
            }
        }
        return -1;
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
