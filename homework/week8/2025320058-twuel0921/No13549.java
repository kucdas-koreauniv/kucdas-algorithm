import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//숨바꼭질 3 풀이 코드
public class No13549 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] time = new int[100001];
        boolean[] visited = new boolean[100001];
        //가능한 최댓값+1로 배열을 초기화
        //10만에서 0으로 가는 경우가 자명히 최댓값이다.
        //이 경우 나오는 길이가 10만이므로 10만1로 초기화해준다.
        Arrays.fill(time, 100001);
        System.out.println(findMinTime(time,visited,n,k));
    }
    //visited를 이용한 버전의 0-1 BFS
    private static int findMinTime(int[] time, boolean[] visited, int n, int k) {
        Deque<int[]> deque = new LinkedList<>();
        time[n] = 0;
        deque.add(new int[] {n, 0});
        while(!deque.isEmpty()) {
            int[] node = deque.pollFirst();
            if(!visited[node[0]]) {
                visited[node[0]] = true;
                if(node[0] == k) {
                    return node[1];
                }
                if(node[0]-1 >= 0 && node[1] + 1 < time[node[0]-1]) {
                    time[node[0]-1] = node[1]+1;
                    deque.addLast(new int[] {node[0]-1,node[1] + 1});
                }
                if(node[0]+1 <= 100000 && node[1] + 1 < time[node[0]+1]) {
                    time[node[0]+1] = node[1]+1;
                    deque.addLast(new int[] {node[0]+1,node[1] + 1});
                }
                if(node[0]*2 <= 100000 && node[1] < time[node[0]*2]) {
                    time[node[0]*2] = node[1];
                    deque.addFirst(new int[] {node[0]*2,node[1]});
                }
            }
        }
        return -1;
    }
}
