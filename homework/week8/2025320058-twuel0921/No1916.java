import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최소비용 구하기 풀이 코드
public class No1916 {
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(node1).add(new Edge(node2, w));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        st = new StringTokenizer(br.readLine());
        int[] dest = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        System.out.print(findMinCost(graph, dist, dest));
    }
    private static int findMinCost(List<List<Edge>> graph, int[] dist, int[] dest) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        dist[dest[0]] = 0;
        pq.add(new Edge(dest[0], 0));
        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            if(dist[current.to] < current.weight) {
                continue;
            }
            if(current.to == dest[1]) {
                return current.weight;
            }
            for(int i = 0; i < graph.get(current.to).size(); i++) {
                Edge next = graph.get(current.to).get(i);
                if(current.weight + next.weight < dist[next.to]) {
                    dist[next.to] = current.weight + next.weight;
                    pq.add(new Edge(next.to, current.weight + next.weight));
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
