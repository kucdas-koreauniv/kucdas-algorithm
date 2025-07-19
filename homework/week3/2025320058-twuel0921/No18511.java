import java.util.Scanner;

//큰 수 구성하기 풀이 코드
public class No18511 {
    private static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int size = sc.nextInt();
        int[] k = new int[size];
        for(int i = 0; i < size; i++) {
            k[i] = sc.nextInt();
        }
        System.out.println(getMaxNumUsingK(k, 0));
    }
    private static int getMaxNumUsingK(int[] k, int num) {
        if(num > n) {
            return 0;
        }
        int max = num;
        for(int i = 0; i < k.length; i++) {
            max = Math.max(max, getMaxNumUsingK(k, num*10+k[i]));
        }
        return max;
    }
}