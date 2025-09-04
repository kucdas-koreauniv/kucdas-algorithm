import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//특정한 최단경로 풀이 코드
public class No1504 {
    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<List<Edge>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        st = new StringTokenizer(br.readLine());
        int[] through = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        int[][] min = new int[2][3];
        //1->1st경유->2nd경유->N의 최단 경로
        min[0][0] = findMinDist(graph,dist,1,through[0]);
        Arrays.fill(dist, INF);
        min[0][1] = findMinDist(graph,dist,through[0],through[1]);
        Arrays.fill(dist, INF);
        min[0][2] = findMinDist(graph,dist,through[1],n);
        Arrays.fill(dist, INF);
        //1->2nd경유->1st경유->N의 최단 경로
        min[1][0] = findMinDist(graph,dist,1,through[1]);
        Arrays.fill(dist, INF);
        min[1][1] = findMinDist(graph,dist,through[0],through[1]);
        Arrays.fill(dist, INF);
        min[1][2] = findMinDist(graph,dist,through[0],n);
        //둘 다 갈 수 없는 경로를 포함할 경우
        if((min[0][0]+1)*(min[0][1]+1)*(min[0][2]+1) == 0
            && (min[1][0]+1)*(min[1][1]+1)*(min[1][2]+1) == 0) {
            System.out.println(-1);
        }
        //둘 중 하나가 갈 수 없는 경로를 포함할 경우
        else if((min[0][0]+1)*(min[0][1]+1)*(min[0][2]+1) != 0
                && (min[1][0]+1)*(min[1][1]+1)*(min[1][2]+1) == 0) {
            System.out.println(min[0][0]+min[0][1]+min[0][2]);
        }else if((min[0][0]+1)*(min[0][1]+1)*(min[0][2]+1) == 0
                && (min[1][0]+1)*(min[1][1]+1)*(min[1][2]+1) != 0) {
            System.out.println(min[1][0]+min[1][1]+min[1][2]);
        }
        //둘 다 모두 통과할 수 있는 경우
        else {
            System.out.println(Math.min(min[0][0]+min[0][1]+min[0][2], min[1][0]+min[1][1]+min[1][2]));
        }
    }
    private static int findMinDist(List<List<Edge>> graph, int[] dist, int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        dist[start] = 0;
        pq.add(new Edge(start, 0));
        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            if(dist[current.to] < current.weight) {
                continue;
            }
            if(current.to == end) {
                return current.weight;
            }
            for(int i = 0; i < graph.get(current.to).size(); i++) {
                Edge next = graph.get(current.to).get(i);
                if(dist[current.to] + next.weight < dist[next.to]) {
                    dist[next.to] = dist[current.to] + next.weight;
                    pq.add(new Edge(next.to, dist[current.to] + next.weight));
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
