import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//숨바꼭질 풀이 코드
public class No1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[] visited = new boolean[100001];
        System.out.println(searchMinTime(visited, n, k));
    }
    private static int searchMinTime(boolean[] visited, int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        int timeToFind = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int currentTime = q.poll();
                visited[currentTime] = true;
                if(currentTime == k) {
                    return timeToFind;
                }
                if(currentTime -1 >= 0 && !visited[currentTime -1]) {
                    q.add(currentTime -1);
                }
                if(currentTime +1 <= 100000 && !visited[currentTime +1]) {
                    q.add(currentTime +1);
                }
                if(currentTime *2 <= 100000 && !visited[currentTime *2]) {
                    q.add(currentTime *2);
                }
            }
            timeToFind++;
        }
        return timeToFind;
    }
}