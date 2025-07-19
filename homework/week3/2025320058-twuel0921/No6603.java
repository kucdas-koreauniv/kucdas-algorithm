import java.util.Scanner;

//로또 풀이 코드
public class No6603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int k = sc.nextInt();
            if(k == 0){
                break;
            }
            int[] arr = new int[k];
            int[] comb = new int[6];
            for(int i = 0; i<k;i++){
                arr[i]=sc.nextInt();
            }
            printAllComb(arr,comb,-1, 0);
            System.out.println();
        }
    }

    private static void printAllComb(int[] arr, int[] comb, int arrIdx, int combIdx) {
        if(combIdx == 6) {
            for(int i : comb){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i = arrIdx+1; i < arr.length; i++){
            comb[combIdx]=i;
            printAllComb(arr, comb, i, combIdx+1);
        }
    }
}