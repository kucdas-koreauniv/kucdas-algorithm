import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//도로포장 풀이 코드
public class No1162 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int w = sc.nextInt();
            graph.get(a).add(new Edge(b,w));
            graph.get(b).add(new Edge(a,w));
        }
        long[][] dist = new long[n+1][k+1];
        for(long[] d : dist) {
            Arrays.fill(d, Long.MAX_VALUE);
        }
        System.out.println(getMinDist(graph, dist, 1, n, k));
    }
    private static long getMinDist(List<List<Edge>> graph, long[][] dist, int start, int end, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.edge.weight));
        dist[start][0] = 0;
        pq.add(new Node(new Edge(start, 0), 0));
        while(!pq.isEmpty()) {
            Node top = pq.poll();
            Edge edge = top.edge;
            if(dist[edge.to][top.count] < edge.weight) {
                continue;
            }
            if(edge.to == end) {
                return edge.weight;
            }
            for(int i = 0; i < graph.get(edge.to).size(); i++) {
                Edge next = graph.get(edge.to).get(i);
                if(edge.weight + next.weight < dist[next.to][top.count]) {
                    dist[next.to][top.count] = edge.weight + next.weight;
                    pq.add(new Node(new Edge(next.to, edge.weight + next.weight), top.count));
                }
                if(top.count+1 <= k) {
                    if(edge.weight < dist[next.to][top.count+1]) {
                        dist[next.to][top.count+1] = edge.weight;
                        pq.add(new Node(new Edge(next.to, edge.weight), top.count+1));
                    }
                }
            }
        }
        return -1;
    }
    private static class Node {
        Edge edge;
        int count;
        public Node(Edge edge, int count) {
            this.edge = edge;
            this.count = count;
        }
    }
    private static class Edge {
        int to;
        long weight;
        public Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
