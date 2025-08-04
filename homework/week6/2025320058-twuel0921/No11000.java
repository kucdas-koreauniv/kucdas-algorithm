import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//강의실 배정 풀이 코드
public class No11000 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MinHeap heap = new MinHeap();
        Time[] times = new Time[n];
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            times[i] = new Time(s, t);
        }
        Arrays.sort(times, Comparator.comparingInt(o -> o.s));
        for(int i = 0; i < n; i++) {
            int s = times[i].s;
            int t = times[i].t;
            if(heap.heap.isEmpty()) {
                heap.push(t);
                continue;
            }
            if(heap.root() > s) {
                heap.push(t);
            }else {
                heap.pop();
                heap.push(t);
            }
        }
        System.out.print(heap.heap.size());
    }
    private static class Time {
        int s;
        int t;
        public Time(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }
}
