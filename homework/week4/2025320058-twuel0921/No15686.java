import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//치킨 배달 풀이 코드
public class No15686 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][n];
        List<Pos> chickenList = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 2) {
                    map[i][j] = 0;
                    chickenList.add(new Pos(i,j));
                }
            }
        }
        boolean[] visited = new boolean[chickenList.size()];
        Arrays.fill(visited, false);
        System.out.println(searchMinCityChickenDist(chickenList, visited, map, n, m, 0, 0));
    }
    private static int searchMinCityChickenDist(List<Pos> chickenList, boolean[] visited, int[][] map, int n, int m, int count, int start) {
        if(count == m) {
            int[][] dist = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    dist[i][j] = 2 * n;
                }
            }
            return getCityChickenDistance(map, dist, n);
        }
        int min = Integer.MAX_VALUE;
        for(int i = start; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                Pos p = chickenList.get(i);
                map[p.row][p.col] = 2;
                min = Math.min(min, searchMinCityChickenDist(chickenList, visited, map, n, m, count+1, i+1));
                map[p.row][p.col] = 0;
                visited[i] = false;
            }
        }
        return min;
    }
    private static int getDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1-r2)+Math.abs(c1-c2);
    }
    private static void getChickenDistance(int[][] map, int[][] dist, int n, int r, int c) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1) {
                    dist[i][j] = Math.min(dist[i][j], getDistance(i, j, r, c));
                }
            }
        }
    }
    private static int getCityChickenDistance(int[][] map, int[][] dist, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 2) {
                    getChickenDistance(map, dist, n, i, j);
                }
            }
        }
        int cityChickenDist = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1) {
                    cityChickenDist += dist[i][j];
                }
            }
        }
        return cityChickenDist;
    }
}

class Pos {
    int row;
    int col;
    public Pos(int row, int col) {
        this.row = row;
        this.col = col;
    }
}