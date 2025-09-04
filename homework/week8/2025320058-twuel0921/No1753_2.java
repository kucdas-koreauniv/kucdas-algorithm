import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최단경로 풀이 코드
public class No1753_2 {
    private static final int INF = 999999;
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
        Arrays.fill(dist, INF);
        dijikstra(graph, dist, k);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= v; i++) {
            sb.append(dist[i] == INF ? "INF" : dist[i]).append('\n');
        }
        System.out.print(sb);
    }
    private static void dijikstra(List<List<Edge>> graph, int[] dist, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        dist[start] = 0;
        pq.add(new Edge(start, 0));
        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            if(dist[current.to] < current.weight) {
                continue;
            }
            for(int i = 0; i < graph.get(current.to).size(); i++) {
                Edge next = graph.get(current.to).get(i);
                if(dist[current.to] + next.weight < dist[next.to]) {
                    dist[next.to] = dist[current.to] + next.weight;
                    pq.add(new Edge(next.to, dist[current.to] + next.weight));
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
