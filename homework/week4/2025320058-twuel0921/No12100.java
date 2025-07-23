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
        char[] dir = {'U', 'D', 'L', 'R'};
        long max = 0;
        for(int i = 0; i < 4; i++) {
            long[][] nextBoard = new long[board.length][board.length];
            for(int row = 0; row < board.length; row++) {
                for(int col = 0; col < board.length; col++) {
                    nextBoard[row][col] = board[row][col];
                }
            }
            moveBlocksInBoard(nextBoard, dir[i]);
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
    private static void moveBlocksInBoard(long[][] board, char dir) {
        int[][] moveDir = {{-1,0},{1,0},{0,-1},{0,1}};
        switch(dir) {
            case 'U':
                for(int col = 0; col < board.length; col++) {
                    boolean[] hasCombined = new boolean[board.length];
                    Arrays.fill(hasCombined, false);
                    for(int row = 0; row < board.length; row++) {
                        moveBlock(board, row, col, moveDir[0], hasCombined);
                    }
                }
                break;
            case 'D':
                for(int col = 0; col < board.length; col++) {
                    boolean[] hasCombined = new boolean[board.length];
                    Arrays.fill(hasCombined, false);
                    for(int row = board.length-1; row >= 0; row--) {
                        moveBlock(board, row, col, moveDir[1], hasCombined);
                    }
                }
                break;
            case 'L':
                for(int row = 0; row < board.length; row++) {
                    boolean[] hasCombined = new boolean[board.length];
                    Arrays.fill(hasCombined, false);
                    for(int col = 0; col < board.length; col++) {
                        moveBlock(board, row, col, moveDir[2], hasCombined);
                    }
                }
                break;
            case 'R':
                for(int row = 0; row < board.length; row++) {
                    boolean[] hasCombined = new boolean[board.length];
                    Arrays.fill(hasCombined, false);
                    for(int col = board.length-1; col >= 0; col--) {
                        moveBlock(board, row, col, moveDir[3], hasCombined);
                    }
                }
                break;
        }
    }
    private static void moveBlock(long[][] board, int targetRow, int targetCol, int[] moveDir, boolean[] hasCombined) {
        int nextRow = targetRow + moveDir[0];
        int nextCol = targetCol + moveDir[1];
        if(nextRow < 0
                || nextRow >= board.length
                || nextCol < 0
                || nextCol >= board.length) {
            return;
        }
        if(board[nextRow][nextCol] == 0) { //다음 칸이 빈칸일 경우
            board[nextRow][nextCol] = board[targetRow][targetCol];
            board[targetRow][targetCol] = 0;
            moveBlock(board, nextRow, nextCol, moveDir, hasCombined);
        }else if(board[nextRow][nextCol] == board[targetRow][targetCol] && !hasCombined[nextRow != targetRow ? nextRow : nextCol] && !hasCombined[nextRow != targetRow ? targetRow : targetCol]) { //현재칸과 다음칸의 수가 같으면서 합쳐진적이 없을 경우
            board[nextRow][nextCol] *= 2;
            board[targetRow][targetCol] = 0;
            hasCombined[nextRow != targetRow ? nextRow : nextCol] = true; //행, 열 중 움직이는 줄을 기준으로 판단하기 위한 수식
            moveBlock(board, nextRow, nextCol, moveDir, hasCombined);
        }
    }
}
