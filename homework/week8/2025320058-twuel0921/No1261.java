import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//알고스팟 풀이 코드
public class No1261 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] map = new char[n][m];
        for(int i = 0; i < n; i++) {
            String line = sc.next();
            for(int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        int[][] count = new int[n][m];
        for(int[] c : count) {
            //가능한 최댓값은 (0,0)과 (n-1,m-1)의 해밀턴거리이다.
            Arrays.fill(c, n+m-1);
        }
        System.out.println(findMinBreak(map,count,n,m));
    }
    private static final int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    //현재가 최솟값인지를 이용한 버전의 0-1 BFS
    private static int findMinBreak(char[][] map, int[][] count, int n, int m) {
        Deque<Node> deque = new LinkedList<>();
        count[0][0] = 0;
        deque.add(new Node(0, 0, 0));
        while(!deque.isEmpty()) {
            Node node = deque.pollFirst();
            if(count[node.row][node.col] < node.count) {
                continue;
            }
            if(node.row == n-1 && node.col == m-1) {
                return node.count;
            }
            for(int i = 0; i < 4; i++) {
                int nextRow = node.row+dir[i][0];
                int nextCol = node.col+dir[i][1];
                if(nextRow < 0 || nextRow >= n
                    || nextCol < 0 || nextCol >= m) {
                    continue;
                }
                if(map[nextRow][nextCol] == '0') {
                    if(node.count < count[nextRow][nextCol]) {
                        count[nextRow][nextCol] = node.count;
                        deque.addFirst(new Node(nextRow, nextCol, node.count));
                    }
                }else {
                    if(node.count + 1 < count[nextRow][nextCol]) {
                        count[nextRow][nextCol] = node.count+1;
                        deque.addLast(new Node(nextRow, nextCol, node.count+1));
                    }
                }
            }
        }
        return -1;
    }
    private static class Node {
        int row;
        int col;
        int count;
        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}
