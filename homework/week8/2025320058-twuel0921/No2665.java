import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//미로만들기 풀이 코드
public class No2665 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][n];
        for(int i = 0; i < n; i++) {
            String line = sc.next();
            for(int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        int[][] change = new int[n][n];
        for(int[] c : change) {
            //가능한 최댓값은 (0,0)과 (n-1,n-1)의 해밀턴거리이다.
            Arrays.fill(c, 2*n-1);
        }
        System.out.println(findMinChange(map, change,n));
    }
    private static final int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    //현재가 최솟값인지를 이용한 버전의 0-1 BFS
    private static int findMinChange(char[][] map, int[][] change, int n) {
        Deque<Node> deque = new LinkedList<>();
        change[0][0] = 0;
        deque.add(new Node(0, 0, 0));
        while(!deque.isEmpty()) {
            Node node = deque.pollFirst();
            if(change[node.row][node.col] < node.change) {
                continue;
            }
            if(node.row == n-1 && node.col == n-1) {
                return node.change;
            }
            for(int i = 0; i < 4; i++) {
                int nextRow = node.row+dir[i][0];
                int nextCol = node.col+dir[i][1];
                if(nextRow < 0 || nextRow >= n
                        || nextCol < 0 || nextCol >= n) {
                    continue;
                }
                if(map[nextRow][nextCol] == '1') {
                    if(node.change < change[nextRow][nextCol]) {
                        change[nextRow][nextCol] = node.change;
                        deque.addFirst(new Node(nextRow, nextCol, node.change));
                    }
                }else {
                    if(node.change + 1 < change[nextRow][nextCol]) {
                        change[nextRow][nextCol] = node.change +1;
                        deque.addLast(new Node(nextRow, nextCol, node.change +1));
                    }
                }
            }
        }
        return -1;
    }
    private static class Node {
        int row;
        int col;
        int change;
        public Node(int row, int col, int change) {
            this.row = row;
            this.col = col;
            this.change = change;
        }
    }
}
