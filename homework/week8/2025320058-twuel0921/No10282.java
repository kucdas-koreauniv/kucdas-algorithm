import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//해킹 풀이 코드
public class No10282 {
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int c = sc.nextInt();
            List<List<Edge>> graph = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for(int i = 0; i < d; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int s = sc.nextInt();
                graph.get(b).add(new Edge(a, s));
            }
            int[] time = new int[n+1];
            Arrays.fill(time, INF);
            findTime(graph, time, c);
            int num = 0;
            int max = 0;
            for(int i : time) {
                if(i != INF) {
                    num++;
                    max = Math.max(max, i);
                }
            }
            sb.append(num).append(" ").append(max).append('\n');
        }
        System.out.println(sb);
    }
    private static void findTime(List<List<Edge>> graph, int[] time, int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        time[start] = 0;
        pq.add(new Edge(start, 0));
        while(!pq.isEmpty()) {
            Edge top = pq.poll();
            if(time[top.to] < top.weight) {
                continue;
            }
            for(int i = 0; i < graph.get(top.to).size(); i++) {
                Edge next = graph.get(top.to).get(i);
                if(top.weight + next.weight < time[next.to]) {
                    time[next.to] = top.weight + next.weight;
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
