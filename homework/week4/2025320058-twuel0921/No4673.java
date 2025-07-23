//셀프 넘버 풀이 코드
public class No4673 {
    public static void main(String[] args){
        boolean isSelfNum;
        for(int i = 1; i <= 10000; i++){
            isSelfNum = true;
            for(int j = 1; j <= i; j++){
                if(i == d(j)){
                    isSelfNum = false;
                }
            }
            if(isSelfNum) System.out.println(i);
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