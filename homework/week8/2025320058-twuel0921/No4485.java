import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//녹색 옷 입은 애가 젤다지? 풀이 코드
public class No4485 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 1;
        StringBuilder sb = new StringBuilder();
        while(true) {
            int n = sc.nextInt();
            if(n == 0) {
                break;
            }
            int[][] map = new int[n][n];
            int[][] cost = new int[n][n];
            for(int[] c : cost) {
                Arrays.fill(c, (2*n-1)*9);
            }
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            sb.append("Problem ").append(num++).append(": ").append(findMinCost(map, cost, n)).append('\n');
        }
        System.out.println(sb);
    }
    private static final int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    private static int findMinCost(int[][] map, int[][] cost, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        cost[0][0] = map[0][0];
        pq.add(new Node(0, 0, cost[0][0]));
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            if(cost[current.row][current.col] < current.cost) {
                continue;
            }
            if(current.row == n-1 && current.col == n-1) {
                return current.cost;
            }
            for(int i = 0; i < 4; i++) {
                int nextRow = current.row + dir[i][0];
                int nextCol = current.col + dir[i][1];
                if(nextRow < 0 || nextRow >= n
                    || nextCol < 0 || nextCol >= n) {
                    continue;
                }
                if(current.cost + map[nextRow][nextCol] < cost[nextRow][nextCol]) {
                    cost[nextRow][nextCol] = current.cost + map[nextRow][nextCol];
                    pq.add(new Node(nextRow, nextCol, cost[nextRow][nextCol]));
                }
            }
        }
        return -1;
    }
    private static class Node {
        int row;
        int col;
        int cost;
        public Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
}
