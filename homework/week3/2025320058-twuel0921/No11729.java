import java.util.Scanner;

//하노이 탑 이동 순서 풀이 코드
public class No11729 {
    private static StringBuilder sb = new StringBuilder();

    private static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        hanoi(n, 1, 3);
        System.out.println(count);
        System.out.println(sb.toString());
    }

    private static void hanoi(int n, int from, int to) {
        if(n == 1) {
            sb.append(from).append(" ").append(to).append('\n');
            count++;
            return;
        }
        hanoi(n-1, from, 6-from-to);
        sb.append(from).append(" ").append(to).append('\n');
        count++;
        hanoi(n-1, 6-from-to, to);
    }
}