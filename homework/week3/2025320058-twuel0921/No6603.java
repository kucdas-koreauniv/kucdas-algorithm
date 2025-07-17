import java.util.Scanner;

//로또 풀이 코드
public class No6603 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int k = sc.nextInt();
            if(k == 0){
                break;
            }
            int[] arr = new int[k];
            int[] comb = new int[6];
            comb[0] = -1;
            for(int i = 0; i<k;i++){
                arr[i]=sc.nextInt();
            }
            printAllComb(arr,comb,0);
            System.out.println();
        }
    }

    private static void printAllComb(int[] arr, int[] comb, int len) {
        if(len == 6){
            for(int i : comb){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        int start = comb[Math.max(len - 1, 0)];
        for(int i = start+1; i < arr.length; i++){
            comb[len]=i;
            printAllComb(arr, comb, len+1);
        }
    }
}