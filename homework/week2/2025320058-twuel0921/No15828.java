import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Router 풀이 코드
public class No15828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        while(true) {
            int input = sc.nextInt();
            if(input > 0) {
                if(queue.size() < n) {
                    queue.offer(input);
                }
            }else if(input == 0) {
                queue.poll();
            }else {
                if(queue.isEmpty()) {
                    System.out.println("empty");
                }else {
                    while(!queue.isEmpty()) {
                        System.out.print(queue.poll() + " ");
                    }
                }
                break;
            }
        }
    }
}