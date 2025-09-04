import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//거의 최단 경로 풀이 코드
public class No5719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) {
                break;
            }
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            List<List<Edge>> graph = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Edge(b,w));
            }
            getMinDist(graph, n, s, d);
            sb.append(getMinDist(graph, n, s, d)).append('\n');
        }
        System.out.println(sb);
    }
    private static int getMinDist(List<List<Edge>> graph, int n, int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<List<Integer>> path = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            path.add(new ArrayList<>());
        }
        dist[start] = 0;
        pq.add(new Edge(start, 0));
        while(!pq.isEmpty()) {
            Edge top = pq.poll();
            if(dist[top.to] < top.weight) {
                continue;
            }
            for(int i = 0; i < graph.get(top.to).size(); i++) {
                Edge next = graph.get(top.to).get(i);
                if(next.isMin) {
                    continue;
                }
                if(top.weight + next.weight < dist[next.to]) {
                    dist[next.to] = top.weight + next.weight;
                    pq.add(new Edge(next.to, top.weight + next.weight));
                    path.get(next.to).clear();
                    path.get(next.to).add(top.to);
                }else if(top.weight + next.weight == dist[next.to]){
                    path.get(next.to).add(top.to);
                }
            }
        }
        deletePath(graph, dist, path, new boolean[graph.size()], end);
        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
    }
    private static void deletePath(List<List<Edge>> graph, int[] dist, List<List<Integer>> path, boolean[] visited, int current) {
        if(visited[current]) {
            return;
        }
        for(int i : path.get(current)) {
            for(Edge e : graph.get(i)) {
                if(e.to == current && dist[e.to] == dist[i] + e.weight) {
                    e.setMin();
                    visited[e.to] = true;
                    deletePath(graph, dist, path, visited, i);
                }
            }
        }
    }
    private static class Edge {
        int to;
        int weight;
        private boolean isMin = false;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        public void setMin() {
            isMin = true;
        }
    }
}
