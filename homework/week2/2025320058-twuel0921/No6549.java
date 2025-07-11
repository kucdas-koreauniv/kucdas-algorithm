import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//히스토그램에서 가장 큰 직사각형 풀이 코드
public class No6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String line = br.readLine();
            if(line.equals("0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Stack<Integer> stack = new Stack<>();
            long maxArea = 0;
            for(int i = 0; i < n; i++) {
                while((!stack.isEmpty()) && arr[stack.peek()] >= arr[i]) {
                    int height = arr[stack.pop()];
                    int width;
                    if(stack.isEmpty()) {
                        width = i;
                    }else {
                        width = i - 1 - stack.peek();
                    }
                    maxArea = Math.max(maxArea, (long) height * (long) width);
                }
                stack.push(i);
            }
            while(!stack.isEmpty()) {
                int height = arr[stack.pop()];
                int width;
                if(stack.isEmpty()) {
                    width = n;
                }else {
                    width = n - 1 - stack.peek();
                }
                maxArea = Math.max(maxArea, (long) height * (long) width);
            }
            sb.append(maxArea).append('\n');
        }
        System.out.println(sb);
    }
}