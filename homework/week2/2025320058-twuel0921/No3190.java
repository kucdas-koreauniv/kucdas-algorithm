import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//뱀 풀이 코드
public class No3190 {
    private static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                map[i][j] = 0;
            }
        }
        int k = sc.nextInt();
        for(int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = 1;
        }
        int l = sc.nextInt();
        Rotate[] rotateArr = new Rotate[l];
        for(int i = 0; i < l; i++) {
            rotateArr[i] = new Rotate(sc.nextInt(), sc.next());
        }
        int time = 0;
        int dirIndex = 0;
        int rotateIndex = 0;
        Deque<Pos> deque = new LinkedList<>();
        deque.add(new Pos(1, 1));
        while(true) {
            Pos head = deque.getFirst();
            int[] currentDir = dir[dirIndex];
            Pos next = new Pos(head.x+currentDir[0], head.y+currentDir[1]);
            time++;
            if(next.x > n || next.x < 1 || next.y > n || next.y < 1 || containPos(deque, next)) {
                break;
            }
            deque.offerFirst(next);
            if(map[next.x][next.y] == 0) {
                deque.pollLast();
            }else {
                map[next.x][next.y] = 0;
            }
            if(rotateIndex < l && time == rotateArr[rotateIndex].time) {
                dirIndex = getRotatedDir(dirIndex, rotateArr[rotateIndex].c);
                rotateIndex++;
            }
        }
        System.out.println(time);
    }

    private static int getRotatedDir(int dir, String c) {
        int rotate;
        if(c.equals("D")) {
            rotate = 1;
        }else {
            rotate = -1;
        }
        return (4 + dir + rotate) % 4;
    }

    private static boolean containPos(Deque<Pos> deque, Pos next) {
        boolean contain = false;
        for(Pos p : deque) {
            if(p.x == next.x && p.y == next.y){
                contain = true;
                break;
            }
        }
        return contain;
    }
}

class Rotate {
    int time;
    String c;
    public Rotate(int time, String c) {
        this.time = time;
        this.c = c;
    }
}

class Pos {
    int x;
    int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}