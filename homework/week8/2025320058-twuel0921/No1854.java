import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//K번째 최단경로 찾기 풀이 코드
public class No1854 {
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
