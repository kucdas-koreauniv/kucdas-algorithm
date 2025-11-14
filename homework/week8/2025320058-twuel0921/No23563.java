import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//벽 타기 풀이 코드
public class No23563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        char[][] map = new char[h][w];
        int[] start = new int[0], end = new int[0];
        for(int i = 0; i < h; i++) {
            String line = sc.next();
            for(int j = 0; j < w; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'S') {
                    map[i][j] = '.';
                    start = new int[] {i,j};
                } else if(map[i][j] == 'E') {
                    map[i][j] = '.';
                    end = new int[] {i,j};
                }
            }
        }
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(map[i][j] == '#') {
                    for(int k = 0; k < 4; k++) {
                        int nextRow = i + dir[k][0];
                        int nextCol = j + dir[k][1];
                        if (nextRow < 0 || nextRow >= h
                                || nextCol < 0 || nextCol >= w) {
                            continue;
                        }
                        if(map[nextRow][nextCol] == '.') {
                            map[nextRow][nextCol] = 'n';
                        }
                    }
                }
            }
        }
        int[][] count = new int[h][w];
        for(int[] c : count) {
            //가능한 최댓값은 (0,0)과 (n-1,m-1)의 해밀턴거리이다.
            Arrays.fill(c, h+w-1);
        }
        System.out.println(findMinMove(map, count, start, end, h, w));
    }
    private static final int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    //현재가 최솟값인지를 이용한 버전의 0-1 BFS
    private static int findMinMove(char[][] map, int[][] count, int[] start, int[] end, int h, int w) {
        Deque<Node> deque = new LinkedList<>();
        count[start[0]][start[1]] = 0;
        deque.add(new Node(start[0], start[1], 0));
        while(!deque.isEmpty()) {
            Node node = deque.pollFirst();
            if(count[node.row][node.col] < node.count) {
                continue;
            }
            if(node.row == end[0] && node.col == end[1]) {
                return node.count;
            }
            for(int i = 0; i < 4; i++) {
                int nextRow = node.row+dir[i][0];
                int nextCol = node.col+dir[i][1];
                if(nextRow < 0 || nextRow >= h
                        || nextCol < 0 || nextCol >= w
                        || map[nextRow][nextCol] == '#') {
                    continue;
                }
                if(map[node.row][node.col] == '.') {
                    if(node.count +1 < count[nextRow][nextCol]) {
                        count[nextRow][nextCol] = node.count +1;
                        deque.addLast(new Node(nextRow, nextCol, node.count +1));
                    }
                }else {
                    if(map[nextRow][nextCol] == '.') {
                        if(node.count + 1 < count[nextRow][nextCol]) {
                            count[nextRow][nextCol] = node.count +1;
                            deque.addLast(new Node(nextRow, nextCol, node.count +1));
                        }
                    }else {
                        if(node.count < count[nextRow][nextCol]) {
                            count[nextRow][nextCol] = node.count;
                            deque.addFirst(new Node(nextRow, nextCol, node.count));
                        }
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
