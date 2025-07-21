import java.util.Scanner;

//Z 풀이 코드
public class No1074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = (1<<n);
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(findOrder(0, 0, size, r, c, 0));
    }
    private static int findOrder(int row, int col, int size, int r, int c, int num) {
        if(size == 1) {
            return num;
        }
        int nextSize = size/2;
        if(r < row+nextSize && c < col+nextSize) {
            return findOrder(row,col,nextSize,r,c,num);
        } else if(r < row+nextSize && c >= col+nextSize) {
            return findOrder(row,col+nextSize,nextSize,r,c,num+(nextSize*nextSize));
        } else if(r >= row+nextSize && c < col+nextSize) {
            return findOrder(row+nextSize,col,nextSize,r,c,num+2*(nextSize*nextSize));
        } else if(r >= row+nextSize && c >= col+nextSize) {
            return findOrder(row+nextSize,col+nextSize,nextSize,r,c,num+3*(nextSize*nextSize));
        }
        return -1;
    }
}