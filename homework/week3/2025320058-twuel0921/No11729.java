import java.util.Scanner;

//하노이 탑 이동 순서 풀이 코드
public class No11729 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        System.out.println(hanoi(sb, n, 1, 3, 0));
        System.out.println(sb);
    }

    private static int hanoi(StringBuilder sb, int n, int from, int to, int count) {
        if(n == 1) {
            sb.append(from).append(" ").append(to).append('\n');
            return count+1;
        }
        int hanoi = 0;
        hanoi += hanoi(sb, n-1, from, 6-from-to, count);
        sb.append(from).append(" ").append(to).append('\n');
        hanoi++;
        hanoi += hanoi(sb, n-1, 6-from-to, to, count);
        return hanoi;
    }
}