import java.util.Arrays;
import java.util.Scanner;

//2048 (Easy) 풀이 코드
public class No12100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] board = new long[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        System.out.println(searchMaxNum(board, 0));
    }
    private static long searchMaxNum(long[][] board, int depth) {
        if(depth == 5) {
            return getMaxNum(board);
        }
        long max = 0;
        for(int i = 0; i < 4; i++) {
            long[][] nextBoard = new long[board.length][board.length];
            for(int row = 0; row < board.length; row++) {
                for(int col = 0; col < board.length; col++) {
                    nextBoard[row][col] = board[row][col];
                }
            }
            moveBlocksInBoard(nextBoard, i);
            max = Math.max(max, searchMaxNum(nextBoard, depth+1));
        }
        return max;
    }
    private static long getMaxNum(long[][] board) {
        long max = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                max = Math.max(max, board[i][j]);
            }
        }
        return max;
    }
    private static void moveBlocksInBoard(long[][] board, int rotation) {
        rotateBoard(board, rotation);
        for(int row = 0; row < board.length; row++) {
            moveBlockToLeft(board, row);
        }
        rotateBoard(board, 4-rotation);
    }
    private static void moveBlockToLeft(long[][] board, int row) {
        boolean[] hasCombined = new boolean[board.length];
        Arrays.fill(hasCombined, false);
        for(int col = 0; col < board.length; col++) {
            int currentCol = col;
            while(currentCol > 0) {
                if(board[row][currentCol-1] == 0) { //다음 칸이 빈칸일 경우
                    board[row][currentCol-1] = board[row][currentCol];
                    board[row][currentCol] = 0;
                }else if(board[row][currentCol-1] == board[row][currentCol] && !hasCombined[currentCol-1] && !hasCombined[currentCol]) { //현재칸과 다음칸의 수가 같으면서 합쳐진적이 없을 경우
                    board[row][currentCol-1] *= 2;
                    board[row][currentCol] = 0;
                    hasCombined[currentCol-1] = true;
                }
                currentCol--;
            }
        }
    }
    private static void rotateBoard(long[][] board, int rotation) {
        int n = board.length;
        for (int k = 0; k < rotation; k++) {
            long[][] temp = new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[j][n - 1 - i] = board[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                System.arraycopy(temp[i], 0, board[i], 0, n);
            }
        }
    }
}
