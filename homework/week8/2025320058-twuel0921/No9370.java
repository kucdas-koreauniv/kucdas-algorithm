import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//미확인 도착지 풀이 코드
public class No9370 {
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        StringBuilder out = new StringBuilder();
        while(test-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();
            int s = sc.nextInt();
            int g = sc.nextInt();
            int h = sc.nextInt();
            List<List<Edge>> graph = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for(int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int d = sc.nextInt();
                graph.get(a).add(new Edge(b, d));
                graph.get(b).add(new Edge(a, d));
            }
            int[] dest = new int[t];
            for(int i = 0; i < t; i++) {
                dest[i] = sc.nextInt();
            }
            Arrays.sort(dest);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < t; i++) {
                int[] dist = new int[n+1];
                Arrays.fill(dist, INF);
                int[][] min = new int[2][3];
                min[0][0] = getMinDist(graph,dist,s,g);
                Arrays.fill(dist, INF);
                min[0][1] = getMinDist(graph,dist,g,h);
                Arrays.fill(dist, INF);
                min[0][2] = getMinDist(graph,dist,h,dest[i]);
                Arrays.fill(dist, INF);
                min[1][0] = getMinDist(graph,dist,s,h);
                Arrays.fill(dist, INF);
                min[1][1] = getMinDist(graph,dist,h,g);
                Arrays.fill(dist, INF);
                min[1][2] = getMinDist(graph,dist,g,dest[i]);
                if((min[0][0]+1)*(min[0][2]+1) != 0
                        && (min[1][0]+1)*(min[1][2]+1) == 0) {
                    int minSum = min[0][0]+min[0][1]+min[0][2];
                    Arrays.fill(dist, INF);
                    if(minSum == getMinDist(graph,dist,s,dest[i])) {
                        sb.append(dest[i]).append(' ');
                    }
                }else if((min[0][0]+1)*(min[0][2]+1) == 0
                        && (min[1][0]+1)*(min[1][2]+1) != 0) {
                    int minSum = min[1][0]+min[1][1]+min[1][2];
                    Arrays.fill(dist, INF);
                    if(minSum == getMinDist(graph,dist,s,dest[i])) {
                        sb.append(dest[i]).append(' ');
                    }
                }else {
                    int minSum = Math.min(min[0][0]+min[0][1]+min[0][2],min[1][0]+min[1][1]+min[1][2]);
                    Arrays.fill(dist, INF);
                    if(minSum == getMinDist(graph,dist,s,dest[i])) {
                        sb.append(dest[i]).append(' ');
                    }
                }
            }
            out.append(sb).append('\n');
        }
        System.out.println(out);
    }
    private static int getMinDist(List<List<Edge>> graph, int[] dist, int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        dist[start] = 0;
        pq.add(new Edge(start, 0));
        while(!pq.isEmpty()) {
            Edge top = pq.poll();
            if(dist[top.to] < top.weight) {
                continue;
            }
            if(top.to == end) {
                return top.weight;
            }
            for(int i = 0; i < graph.get(top.to).size(); i++) {
                Edge next = graph.get(top.to).get(i);
                if(top.weight + next.weight < dist[next.to]) {
                    dist[next.to] = top.weight + next.weight;
                    pq.add(new Edge(next.to, top.weight + next.weight));
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
