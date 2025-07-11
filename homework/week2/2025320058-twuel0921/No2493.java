import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//탑 풀이 코드
public class No2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            int next = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()) {
                sb.append("0").append(" ");
                stack.push(new int[]{i, next});
            } else {
                while(true) {
                    if(stack.isEmpty()) {
                        sb.append("0").append(" ");
                        stack.push(new int[]{i, next});
                        break;
                    }
                    int[] peek = stack.peek();
                    if(peek[1] > next) {
                        sb.append(peek[0]).append(" ");
                        stack.push(new int[]{i, next});
                        break;
                    }else {
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(sb);
    }
}