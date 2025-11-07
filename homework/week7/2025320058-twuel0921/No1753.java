import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최단경로 풀이 코드
public class No1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(node1).add(new Edge(node2, w));
        }
        int[] dist = new int[v+1];
        for(int i = 1; i <= v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dijikstra(graph,dist,k);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= v; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
        }
        System.out.print(sb);
    }
    private static void dijikstra(List<List<Edge>> graph, int[] dist, int k) {
        dist[k] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        pq.add(new Edge(k, 0));
        while(!pq.isEmpty()) {
            Edge top = pq.poll();
            int current = top.to;
            int distance = top.weight;
            if(dist[current] < distance) {
                continue;
            }
            for(Edge edge : graph.get(current)) {
                int next = edge.to;
                int nextDistance = distance + edge.weight;
                if(dist[next] > nextDistance) {
                    dist[next] = nextDistance;
                    pq.add(new Edge(next, nextDistance));
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
