import java.util.Scanner;

//별 찍기 - 19 풀이 코드
public class No10994 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = 4*n-3;
        char[][] stars = new char[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                stars[i][j] = ' ';
            }
        }
        putStar(stars, n);
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.print(stars[i][j]);
            }
            System.out.println();
        }
    }
    private static void putStar(char[][] stars, int n) {
        int size = stars.length;
        int currentSize = 4*n-3;
        if(n == 1) {
            stars[size/2][size/2] = '*';
            return;
        }
        for(int i = -(currentSize/2); i <= currentSize/2; i++) {
            stars[size/2-currentSize/2][size/2+i] = '*';
            stars[size/2+currentSize/2][size/2+i] = '*';
            stars[size/2+i][size/2-currentSize/2] = '*';
            stars[size/2+i][size/2+currentSize/2] = '*';
        }
        putStar(stars, n-1);
    }
}