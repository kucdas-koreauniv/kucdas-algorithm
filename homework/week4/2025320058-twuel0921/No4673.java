import java.util.Arrays;

//셀프 넘버 풀이 코드
public class No4673 {
    public static void main(String[] args) {
        boolean[] selfNum = new boolean[20000];
        Arrays.fill(selfNum, true);
        for(int i = 1; i <= 10000; i++){
            selfNum[d(i)] = false;
        }
        for(int i = 1; i <= 10000; i++){
            if(selfNum[i]) {
                System.out.println(i);
            }
        }
    }

    private static int d(int n){
        int sum = n;
        while(n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}